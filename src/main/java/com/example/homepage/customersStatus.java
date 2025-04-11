package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class customersStatus {
    Stage stage;
    Scene scene;
    @FXML
    private AnchorPane choice;

    public void requestAccount(ActionEvent event) throws IOException {
        choice.setVisible(true);
    }
    public void requestNormal(ActionEvent event) throws IOException {
        Button bt = (Button) event.getSource();
        HesabRequest hesabRequest = new HesabRequest(new Date(),bt.getText(),Global.requestCount,Global.currentUser,0.05);
        hesabRequest.setRequesterUsername(Global.currentUser.getUsername());
        hesabRequest.setRequester(Global.currentUser);
        Global.currentUser.getMyRequests().add(hesabRequest);
        Global.getRequests().add(hesabRequest);
        fileHandling.writeToFileRequests();
        System.out.print("sent");

    }
    public void requestSavings(ActionEvent event) throws IOException {
        Button bt = (Button) event.getSource();
        HesabRequest hesabRequest = new HesabRequest(new Date(),bt.getText(),Global.requestCount,Global.currentUser,0.2);
        hesabRequest.setRequesterUsername(Global.currentUser.getUsername());
        hesabRequest.setRequester(Global.currentUser);
        Global.currentUser.getMyRequests().add(hesabRequest);
        Global.getRequests().add(hesabRequest);
        fileHandling.writeToFileRequests();
        System.out.print("sent");

    }

    public void backToHomePageFromStatus(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
    }
}
