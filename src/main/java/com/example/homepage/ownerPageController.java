package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ownerPageController {
    private Stage stage;
    private Scene scene;

    public void changeToAddAdmin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addAdminPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Parent root = loader.load();
        scene = new Scene(root, 1080, 750);
        stage.setScene(scene);
        stage.show();
    }
}
