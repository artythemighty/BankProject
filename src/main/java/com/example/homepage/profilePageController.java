package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
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
    @FXML
    private HBox emailBox;
    @FXML
    private Label birthday;
    @FXML
    private ImageView profileImg;
    @FXML
    private ImageView profileImg1;
    Stage stage;
    Scene scene;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Global.currentUser.getGender().equals("female")) {
            profileImg.setImage(new Image("D:\\BankProject\\BankProject\\src\\main\\resources\\com\\example\\homepage\\female icon.png"));
            profileImg1.setImage(new Image("D:\\BankProject\\BankProject\\src\\main\\resources\\com\\example\\homepage\\female icon.png"));
        }
        if (Global.currentUser.getEmail()==null){
            Button button = new Button();
            button.setText("Add Email");
            button.setStyle("-fx-background-color: #49e6c9");
            emailBox.getChildren().add(button);
        }
        name.setText(Global.currentUser.getName());
        surname.setText(Global.currentUser.getSurname());
        age.setText(String.valueOf(Global.currentUser.getAge()));
        gender.setText(Global.currentUser.getGender());
        phone.setText(Global.currentUser.getPhoneNumber());
        date.setText(String.valueOf(Global.currentUser.getJoinDate()));
        birthday.setText(String.valueOf(Global.currentUser.getBirthDate()));
    }
    public void switchToHomepage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
    }
    public void signOut(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("welcomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
    }
}
