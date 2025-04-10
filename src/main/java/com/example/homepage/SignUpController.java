package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

import static com.example.homepage.fileHandling.readFromFileUsers;

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
    @FXML
    private Label signupErrorLabel;
    @FXML
    private Button num1Btn;
    @FXML
    private Button num2Btn;
    @FXML
    private Button num3Btn;
    int max;
    @FXML
    private AnchorPane captcha;
    @FXML
    private Button backBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private Button homeBtn;
    @FXML
    private Label created;
    @FXML
    private Label captchaTitle;
    Stage stage;
    Scene scene;

    public void createCustomer(ActionEvent event) throws IOException {
        boolean validpassword=false;
        boolean validphone=false;
        boolean validgender=false;
        boolean usernameTaken=false;
        boolean isUsername=false;
        boolean isPassword=false;
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
            isUsername=true;
            ArrayList<User> users = Global.getAllUsers();
            for(User user : users){
                if(user.getUsername().equals(username.getText())){
                    usernameTaken=true;
                }
            }
        }
        for(int i = 0; i<age.getLength();i++){
            if (!(age.getText().charAt(i)>='0'&&age.getText().charAt(i)<='9')){
                isAge = false;
            }


        }
        if (!(gender.getText().isEmpty())){
            isGender=true;
            if (gender.getText().equals("male")||gender.getText().equals("female")){
                validgender=true;
            }
        }

        if (name.getText().isEmpty()) {
            isName = false;
        }
        if(!(phone.getText().isEmpty())){
            isPhone=true;
            if (phone.getText().length()==12){
                for (int i = 0;i<phone.getLength();i++){
                    if (phone.getText().charAt(i)>='0'&&phone.getText().charAt(i)<='9'){
                        validphone = true;
                    }
                }

            }

        }
        else
            isPhone = false;
        if (lastName.getText().isEmpty()){
            isLastName = false;


        }
        if(!(password.getText().isEmpty())){
            isPassword=true;
            if (!(password.getText().length()<8)){
                validpassword=true;
            }

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
        if (isName&&isLastName&&isGender&&isAge&&isPhone&&isPassword&&isUsername&&isEmail&&isdate&&isAgreement&&isConfirm&&!usernameTaken&&validgender&&validphone&&validpassword){
            captcha.setVisible(true);
            confirmBtn.setDisable(true);
            signupErrorLabel.setVisible(false);
            backBtn.setDisable(true);
        }

        if(isName==false){
            signupErrorLabel.setText("Please enter your name!");
            signupErrorLabel.setVisible(true);
            signupErrorLabel.setStyle("-fx-text-fill: red;");
        } else if (isLastName==false) {
            signupErrorLabel.setText("Please enter your last name!");
            signupErrorLabel.setVisible(true);
            signupErrorLabel.setStyle("-fx-text-fill: red;");
        } else if (isAge==false) {
            signupErrorLabel.setText("Age is required!");
            signupErrorLabel.setVisible(true);
            signupErrorLabel.setStyle("-fx-text-fill: red;");
        }else if (isdate==false) {
            signupErrorLabel.setText("Please select your birthdate!");
            signupErrorLabel.setVisible(true);
            signupErrorLabel.setStyle("-fx-text-fill: red;");
        }else if (isGender==false) {
            signupErrorLabel.setText("Please enter your gender!");
            signupErrorLabel.setVisible(true);
            signupErrorLabel.setStyle("-fx-text-fill: red;");
        }
        else if (!validgender){
            signupErrorLabel.setText("Gender should be male or female!");
            signupErrorLabel.setVisible(true);
            signupErrorLabel.setStyle("-fx-text-fill: red;");
        }
        else if (isPhone==false) {
            signupErrorLabel.setText("Please enter your phone number!");
            signupErrorLabel.setVisible(true);
            signupErrorLabel.setStyle("-fx-text-fill: red;");
        }
        else if(!validphone){
            signupErrorLabel.setText("Phone number should be 11 digits and only contain numbers!");
        }
        else if (isUsername==false) {
            signupErrorLabel.setText("Username is required!");
            signupErrorLabel.setVisible(true);
            signupErrorLabel.setStyle("-fx-text-fill: red;");
        }
        else if(usernameTaken){
            signupErrorLabel.setText("Username is already taken!");
            signupErrorLabel.setVisible(true);
            signupErrorLabel.setStyle("-fx-text-fill: red;");
        }
        else if(isPassword==false){
            signupErrorLabel.setText("Password is required!");
            signupErrorLabel.setVisible(true);
            signupErrorLabel.setStyle("-fx-text-fill: red;");
        }
        else if(!validpassword){
            signupErrorLabel.setText("Password should be at least 8 digits!");
            signupErrorLabel.setVisible(true);
            signupErrorLabel.setStyle("-fx-text-fill: red;");
        }
        else if (isConfirm==false) {
            signupErrorLabel.setText("Please confirm your password!");
            signupErrorLabel.setVisible(true);
            signupErrorLabel.setStyle("-fx-text-fill: red;");
        }
        else if (!(password.getText().equals(confirmPass.getText()))){
            signupErrorLabel.setText("Password does not match!");
            signupErrorLabel.setVisible(true);
            signupErrorLabel.setStyle("-fx-text-fill: red;");
        }
        else if(isAgreement==false){
            signupErrorLabel.setText("Please read and accept our terms and conditions!");
            signupErrorLabel.setVisible(true);
            signupErrorLabel.setStyle("-fx-text-fill: red;");
        }
    }
    public void setAge(ActionEvent event) {
        Date first=new Date();
        LocalDate date=birthday.getValue();
        int aged = first.getYear()-date.getYear()+1900;
        age.setText(String.valueOf(aged));
    }
    public void captcha(ActionEvent event) throws IOException {
        Button button = (Button) event.getSource();
        if(Integer.parseInt(button.getText())==max){
            homeBtn.setVisible(true);
            created.setVisible(true);
            num1Btn.setVisible(false);
            num2Btn.setVisible(false);
            num3Btn.setVisible(false);
            captchaTitle.setVisible(false);
            Global.getAllUsers().add(new Customer(name.getText(),lastName.getText(),Integer.parseInt(age.getText()),gender.getText(),username.getText(),password.getText(),new Date(),birthday.getValue(),phone.getText()));
            fileHandling.writeToFileUsers(Global.getAllUsers());
            System.out.println("Customer created");
        }
        else
            captchaTitle.setText("Please Try Again!");
        captchaTitle.setStyle("-fx-text-fill: red;");



    }
    public void switchToHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("welcomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        captcha.setVisible(false);
        Random r=new Random();
        int num1 = r.nextInt(999);
        int num2 = r.nextInt(999);
        int num3 = r.nextInt(999);
        num3Btn.setText(String.valueOf(num3));
        num2Btn.setText(String.valueOf(num2));
        num1Btn.setText(String.valueOf(num1));
        max = num1;
        if(num2>max){
            max=num2;
        }
        if(num3>max){
            max=num3;
        }
        age.setEditable(false);
    }
}

