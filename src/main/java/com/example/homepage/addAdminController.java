package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class addAdminController {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField age;
    @FXML
    private TextField gender;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField confirmPassword;
    @FXML
    private Label adminLabelError;

    public void addAdmin(ActionEvent event) throws IOException {
        boolean isName=false;
        boolean isSurname=false;
        boolean isAge=false;
        boolean isGender=false;
        boolean isUsername=false;
        boolean isPassword=false;
        if(!(name.getText().isEmpty())) {
            isName = true;
        }
        if(!(surname.getText().isEmpty())) {
            isSurname = true;
        }
        if(!(age.getText().isEmpty())) {
            for(int i = 0; i<age.getText().length(); i++) {
                if(!(age.getText().charAt(i)>='0'&&age.getText().charAt(i)<='9')) {
                    isAge=false;

                }
                else
                    isAge=true;
            }
        }
        if(gender.getText().equalsIgnoreCase("male")||gender.getText().equalsIgnoreCase("female")) {
            isGender=true;
        }
        if(!(username.getText().isEmpty())) {
            isUsername=true;
        }
        if(password.getText().length()<8) {
            isPassword=false;
        }
        else
            isPassword=true;

        if(isName&&isSurname&&isAge&&isGender&&isUsername&&isPassword) {
            Global.getAllUsers().add(new Admin(name.getText(),surname.getText(),Integer.parseInt(age.getText()),gender.getText(),username.getText(),password.getText(),phoneNumber.getText()));
            fileHandling.writeToFileUsers(Global.getAllUsers());
            System.out.print("admin added");
        }

        if(name.getText().isEmpty()||age.getText().isEmpty()||gender.getText().isEmpty()||username.getText().isEmpty()||password.getText().isEmpty()||phoneNumber.getText().isEmpty()||confirmPassword.getText().isEmpty()) {
            adminLabelError.setVisible(true);
            adminLabelError.setText("Please fill all the fields");
            adminLabelError.setStyle("-fx-text-fill: red;");
            return;
    }
        if(password.getText().length()<8) {
            adminLabelError.setVisible(true);
            adminLabelError.setText("Password must be at least 8 characters");
            adminLabelError.setStyle("-fx-text-fill: red;");
            return;
        }
        if(!(password.getText().equals(confirmPassword.getText()))) {
            adminLabelError.setVisible(true);
            adminLabelError.setText("Passwords do not match");
            adminLabelError.setStyle("-fx-text-fill: red;");
            return;
        }
        if(phoneNumber.getText().length()<11) {
            adminLabelError.setVisible(true);
            adminLabelError.setText("Phone number must be at least 11 numbers");
            adminLabelError.setStyle("-fx-text-fill: red;");
            return;
        }
        if (!(gender.getText().equalsIgnoreCase("male")||gender.getText().equalsIgnoreCase("female"))) {
            adminLabelError.setVisible(true);
            adminLabelError.setText("Gender must be either male or female");
            adminLabelError.setStyle("-fx-text-fill: red;");
            return;
        }
        ArrayList<User> users = Global.getAllUsers();
        for(User user : users) {
            if(user.getUsername().equals(username.getText())) {
                adminLabelError.setVisible(true);
                adminLabelError.setText("Username is already taken");
                adminLabelError.setStyle("-fx-text-fill: red;");
                return;
            }
        }

    }


    Stage stage;
    Scene scene;

    public void backToOwnerPageFromAddAdmin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ownerPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
    }
}
