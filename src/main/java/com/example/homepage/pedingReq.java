package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class pedingReq implements Initializable {
    Stage stage;
    Scene scene;
    ArrayList<Requests> requests = Global.getRequests();
    @FXML
    private TableView<Requests> requestTable;
    @FXML
    private TableColumn<Requests, String> usernameColumn;
    @FXML
    private TableColumn<Requests, String> requestTypeColumn;
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


        usernameColumn.setCellValueFactory(new PropertyValueFactory<Requests, String>("requesterUsername"));
        requestTypeColumn.setCellValueFactory(new PropertyValueFactory<Requests, String>("description"));
        requestDateColumn.setCellValueFactory(new PropertyValueFactory<Requests, Date>("requestDate"));
        requestIdColumn.setCellValueFactory(new PropertyValueFactory<Requests, Integer>("requestId"));
        requestTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        for (Requests request : requests) {
            requestTable.getItems().add(request);
        }


    }

    public void acceptRequest(ActionEvent event) throws IOException {
        Global.getRequests().remove(focusedrequest);
        fileHandling.writeToFileRequests();
        focusedrequest.getRequester().getMyRequests().remove(focusedrequest);
        focusedrequest.setStatus("Accepted");
        focusedrequest.getRequester().getMyRequests().add(focusedrequest);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pendingReq .fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
    }

    public void declineRequest(ActionEvent event) throws IOException {
        Global.getRequests().remove(focusedrequest);
        fileHandling.writeToFileRequests();
        focusedrequest.getRequester().getMyRequests().remove(focusedrequest);
        focusedrequest.setStatus("Declined");
        focusedrequest.getRequester().getMyRequests().add(focusedrequest);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pendingReq .fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();

    }
}
