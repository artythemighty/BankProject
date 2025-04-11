package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class transferSelection {
    Stage stage;
    Scene scene;


    public void swtichToTransfer(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("transfer.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = loader.load();
            scene = new Scene(root, 883, 558);
            stage.setScene(scene);
            stage.setResizable(true);
            stage.show();

    }

    public void backToHomePageFromTransferSelect(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }
}
