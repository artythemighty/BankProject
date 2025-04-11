package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
            Global.getAllUsers().add(new Admin(name.getText(),surname.getText(),Integer.parseInt(age.getText()),gender.getText(),username.getText(),password.getText()));
            fileHandling.writeToFileUsers(Global.getAllUsers());
            System.out.print("admin added");
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
