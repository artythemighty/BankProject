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
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class myRequests implements Initializable {
    Stage stage;
    Scene scene;
    @FXML
    private TableView<Requests> requestsTable;
    @FXML
    private TableColumn<Requests, String> typeColumn;
    @FXML
    private TableColumn<Requests, Date> dateColumn;
    @FXML
    private TableColumn<Requests, String> statusColumn;
    @FXML
    private TableColumn<Requests, Integer> requestIdColumn;
    ArrayList<Requests> requests=Global.currentUser.getMyRequests();

    public void backToHomePageFromPendingRequests(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typeColumn.setCellValueFactory(new PropertyValueFactory<Requests,String>("description"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Requests,String>("status"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Requests,Date>("requestDate"));
        requestIdColumn.setCellValueFactory(new PropertyValueFactory<Requests,Integer>("requestId"));
        requestsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        for (Requests request:requests) {
            requestsTable.getItems().add(request);
        }


    }
}
