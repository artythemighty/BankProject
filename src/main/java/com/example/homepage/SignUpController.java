package com.example.homepage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {
    @FXML
    private TextField NameField;
    @FXML
    private TextField PhoneNumberField;
    @FXML
    private TextField IDNumberField;
    @FXML
    private TextField CardNumberField;
    @FXML
    private TextField CVV2Field;
    @FXML
    private TextField EmailField;
    @FXML
    private Button ConfirmButton;
    @FXML
    private Button BackBtn;

    @FXML
    private void goToSignIn(javafx.event.ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("com/example/homepage/welcomePage.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Sign In");
            stage.setScene(new Scene(root));
            stage.show();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToFinalizeSignup(javafx.event.ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("com/example/homepage/FinalizeSignup.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Finalize Sign Up");
            stage.setScene(new Scene(root));
            stage.show();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


