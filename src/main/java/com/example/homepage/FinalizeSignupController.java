package com.example.banklogin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class FinalizeSignupController {
    @FXML
    private Button BackBtn;
    @FXML
    private Button SignupBtn;
    @FXML
    private CheckBox TermsCheck;
    @FXML
    private TextField UsernameField;
    @FXML
    private TextField PasswordField;
    @FXML
    private TextField ConfirmPassField;
    @FXML
    private Label ErrorLabel;


    @FXML
    private void goBackToSignUp(javafx.event.ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/banklogin/SignUp.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Sign Up");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
