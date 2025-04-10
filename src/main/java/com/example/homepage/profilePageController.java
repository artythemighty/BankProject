package com.example.homepage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class profilePageController implements Initializable {
    @FXML
    private Label nameProp;
    @FXML
    private Label surnameProp;
    @FXML
    private Label ageProp;
    @FXML
    private Label genderProp;
    @FXML
    private Label emailProp;
    @FXML
    private Label phoneProp;
    @FXML
    private Label dateProp;
    @FXML
    private Label name;
    @FXML
    private Label surname;
    @FXML
    private Label age;
    @FXML
    private Label gender;
    @FXML
    private Label email;
    @FXML
    private Label phone;
    @FXML
    private Label date;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText(Global.currentUser.getName());
        surname.setText(Global.currentUser.getSurname());
        age.setText(String.valueOf(Global.currentUser.getAge()));
        gender.setText(Global.currentUser.getGender());
        email.setText(Global.currentUser.getEmail());
        phone.setText(Global.currentUser.getPhoneNumber());
    }
}
