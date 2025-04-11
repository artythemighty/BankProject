package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class pedingReq implements Initializable {
    ArrayList<Requests> requests = Global.getRequests();
    @FXML
    private TableView<Requests> requestTable;
    @FXML
    private TableColumn<Requests,String> usernameColumn;
    @FXML
    private TableColumn<Requests,String> requestTypeColumn;
    @FXML
    private TableColumn<Requests, Date> requestDateColumn;
    @FXML
    private TableColumn<Requests, Integer> requestIdColumn;
    private Requests focusedrequest;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    focusedrequest = requestTable.getFocusModel().getFocusedItem();
                    System.out.println("focused");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }


            }
        });
        thread.setDaemon(true);
        thread.start();



            usernameColumn.setCellValueFactory(new PropertyValueFactory<Requests,String>("requesterUsername"));
        requestTypeColumn.setCellValueFactory(new PropertyValueFactory<Requests,String>("description"));
        requestDateColumn.setCellValueFactory(new PropertyValueFactory<Requests,Date>("requestDate"));
        requestIdColumn.setCellValueFactory(new PropertyValueFactory<Requests,Integer>("requestId"));
        requestTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        for (Requests request : requests) {
            requestTable.getItems().add(request);
        }


    }
    public void acceptRequest(ActionEvent event) {
        focusedrequest.getRequester().getMyRequests().remove(focusedrequest);
        focusedrequest.setStatus("Accepted");
        focusedrequest.getRequester().getMyRequests().add(focusedrequest);
        if (focusedrequest instanceof HesabRequest) {
            Global.currentAdmin.ApproveHesabRequest((HesabRequest) focusedrequest);
            System.out.println("Approved");
            requestTable.getItems().clear();
            for (Requests request : requests) {
                if (request.getRequestId() == focusedrequest.getRequestId()) {
                    requests.remove(request);
                    requestTable.getItems().clear();
                    for(Requests request1 : requests){
                        requestTable.getItems().add(request1);

                    }
                }
            }
        }


    }

    public void declineRequest(ActionEvent event) {
        focusedrequest.getRequester().getMyRequests().remove(focusedrequest);
        focusedrequest.setStatus("Declined");
        focusedrequest.getRequester().getMyRequests().add(focusedrequest);
        for (Requests request : requests) {
            if (request.getRequestId() == focusedrequest.getRequestId()) {
                requests.remove(request);
                requestTable.getItems().clear();
                for(Requests request1 : requests){
                    requestTable.getItems().add(request1);

                }
            }
        }
    }
}
