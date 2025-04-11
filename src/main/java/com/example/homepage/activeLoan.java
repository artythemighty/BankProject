package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class activeLoan {
    Stage stage;
    Scene scene;

     public void backToAdminPageFromActiveLoan(ActionEvent event)throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPage.fxml"));
         stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setResizable(false);
         Parent root = loader.load();
         scene = new Scene(root, 883, 558);
         stage.setScene(scene);
         stage.show();
     }
}
