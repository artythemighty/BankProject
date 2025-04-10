package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private TextField email;
    @FXML
    private TextField name;
    @FXML
    private TextField phone;
    @FXML
    private TextField lastName;
    @FXML
    private TextField gender;
    @FXML
    private TextField age;
    @FXML
    private DatePicker birthday;
    @FXML
    private CheckBox agreement;
    @FXML
    private PasswordField confirmPass;

    public void createCustomer(ActionEvent event) throws IOException {
        boolean isUsername=false;
        boolean isPassword=true;
        boolean isEmail=true;
        boolean isName= true;
        boolean isLastName=true;
        boolean isPhone=false;
        boolean isGender=false;
        boolean isAge=true;
        boolean isdate = true;
        boolean isAgreement=false;
        boolean isConfirm = false;
        if (!(username.getText().isEmpty())){
            isUsername = true;
        }
        for(int i = 0; i<age.getLength();i++){
            if (!(age.getText().charAt(i)>='0'&&age.getText().charAt(i)<='9')){
                isAge = false;
            }


        }
        if (gender.getText().equals("male")||gender.getText().equals("female")){
            isGender = true;
        }
        if (name.getText().isEmpty()) {
            isName = false;
        }
        if (phone.getText().length()==12){
            for (int i = 0;i<phone.getLength();i++){
                if (phone.getText().charAt(i)>='0'&&phone.getText().charAt(i)<='9'){
                    isPhone = true;
                }
            }
        }
        else
            isPhone = false;
        if (lastName.getText().isEmpty()){
            isLastName = false;


        }
        if (password.getText().length()!=8){
            isPassword = false;
        }
        if (birthday.getValue()==null){
            isdate=false;
        }
        if (agreement.isSelected()){
            isAgreement = true;
        }
        if(password.getText().equals(confirmPass.getText())){
            isConfirm = true;
        }
        if (isName&&isLastName&&isGender&&isAge&&isPhone&&isPassword&&isUsername&&isEmail&&isdate&&isAgreement){
            Global.getAllUsers().add(new Customer(name.getText(),lastName.getText(),Integer.parseInt(age.getText()),gender.getText(),username.getText(),password.getText(),new Date(),birthday.getValue()));
            fileHandling.writeToFileUsers(Global.getAllUsers());
            System.out.println("Customer created");
        }
    }
    public void setAge(ActionEvent event) {
        Date first=new Date();
        LocalDate date=birthday.getValue();
        int aged = first.getYear()-date.getYear()+1900;
        age.setText(String.valueOf(aged));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        age.setEditable(false);
    }
}


