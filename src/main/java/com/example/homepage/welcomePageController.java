package com.example.homepage;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
<<<<<<< Updated upstream
import javafx.scene.control.PasswordField;
=======
<<<<<<< HEAD
=======
import javafx.scene.control.PasswordField;
>>>>>>> b6641865378bf64b9fc15ffdf601beb85eb4226f
>>>>>>> Stashed changes
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class welcomePageController implements Initializable {
    String[] messages ={"EVEN SAFER THAN REAL LIFE BANKS!","A USER FRIENDLY ENVIRONMENT","REASONABLE LOANS THAT WON'T BURN THROUGH YOUR POCKET!"};
    int currentMessage = 0;
    boolean played = false;
    @FXML
    private Label message;
    @FXML
    private VBox signInBox;
    @FXML
    private Button checkBtn;
    @FXML
    private Button NextBtn;
    @FXML
    private Button backBtn;
    @FXML
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
    private Button EnterBtn;
    @FXML
    private Button ForgetBtn;
    @FXML
    private Button signUpBtn;
    @FXML
    private TextField UsernameField;
    @FXML
    private TextField PasswordField;
=======
>>>>>>> Stashed changes
    private TextField username;
    @FXML
    private PasswordField password;


<<<<<<< Updated upstream
=======
>>>>>>> b6641865378bf64b9fc15ffdf601beb85eb4226f
>>>>>>> Stashed changes

    public void nextMessage(ActionEvent event) {
        NextBtn.setDisable(true);
        played = false;
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(message);
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(!played) {
                    fadeTransition.setFromValue(0);
                    fadeTransition.setToValue(1);
                    fadeTransition.play();
                    played = true;
                    if (currentMessage == 2) {
                        message.setText(messages[2]);
                        currentMessage = 0;
                    } else {
                        message.setText(messages[currentMessage]);
                        currentMessage++;
                    }
                }
                NextBtn.setDisable(false);
            }
        });





    }
    public void signInAnimation(ActionEvent event) throws IOException {
        backBtn.setDisable(false);
        FadeTransition messageFADE = new FadeTransition();
        messageFADE.setNode(message);
        messageFADE.setDuration(Duration.millis(1000));
        messageFADE.setFromValue(1);
        messageFADE.setToValue(0);
        messageFADE.play();
        FadeTransition boxFade = new FadeTransition();
        boxFade.setNode(signInBox);
        boxFade.setDuration(Duration.millis(1000));
        boxFade.setFromValue(0);
        boxFade.setToValue(1);
        boxFade.play();
        FadeTransition nextFade = new FadeTransition();
        nextFade.setNode(NextBtn);
        nextFade.setDuration(Duration.millis(1000));
        nextFade.setFromValue(1);
        nextFade.setToValue(0);
        nextFade.play();
        FadeTransition checkFade = new FadeTransition();
        checkFade.setNode(checkBtn);
        checkFade.setDuration(Duration.millis(1000));
        checkFade.setFromValue(1);
        checkFade.setToValue(0);
        checkFade.play();
        FadeTransition backBtnFade = new FadeTransition();
        backBtnFade.setNode(backBtn);
        backBtnFade.setDuration(Duration.millis(1000));
        backBtnFade.setFromValue(0);
        backBtnFade.setToValue(1);
        backBtnFade.play();

        TranslateTransition boxTransition = new TranslateTransition();
        boxTransition.setDuration(Duration.millis(1000));
        boxTransition.setNode(signInBox);
        boxTransition.setByX(-755);
        boxTransition.play();
        TranslateTransition messageTransition = new TranslateTransition();
        messageTransition.setDuration(Duration.millis(1000));
        messageTransition.setNode(message);
        messageTransition.setByX(-755);
        messageTransition.play();
        TranslateTransition nextBtnTransition = new TranslateTransition();
        nextBtnTransition.setDuration(Duration.millis(1000));
        nextBtnTransition.setNode(NextBtn);
        nextBtnTransition.setByX(-755);
        nextBtnTransition.play();
        TranslateTransition checkBtnTransition = new TranslateTransition();
        checkBtnTransition.setDuration(Duration.millis(1000));
        checkBtnTransition.setNode(checkBtn);
        checkBtnTransition.setByX(-650);
        checkBtnTransition.play();
        TranslateTransition backBtnTransition = new TranslateTransition();
        backBtnTransition.setDuration(Duration.millis(1000));
        backBtnTransition.setNode(backBtn);
        backBtnTransition.setByX(-650);
        backBtnTransition.play();
        checkBtn.setDisable(true);

    }
    public void backAnimation(ActionEvent event) {
        FadeTransition messageFADE = new FadeTransition();
        messageFADE.setNode(message);
        messageFADE.setDuration(Duration.millis(1000));
        messageFADE.setFromValue(0);
        messageFADE.setToValue(1);
        messageFADE.play();
        FadeTransition boxFade = new FadeTransition();
        boxFade.setNode(signInBox);
        boxFade.setDuration(Duration.millis(1000));
        boxFade.setFromValue(1);
        boxFade.setToValue(0);
        boxFade.play();
        FadeTransition nextFade = new FadeTransition();
        nextFade.setNode(NextBtn);
        nextFade.setDuration(Duration.millis(1000));
        nextFade.setFromValue(0);
        nextFade.setToValue(1);
        nextFade.play();
        FadeTransition checkFade = new FadeTransition();
        checkFade.setNode(checkBtn);
        checkFade.setDuration(Duration.millis(1000));
        checkFade.setFromValue(0);
        checkFade.setToValue(1);
        checkFade.play();
        FadeTransition backBtnFade = new FadeTransition();
        backBtnFade.setNode(backBtn);
        backBtnFade.setDuration(Duration.millis(1000));
        backBtnFade.setFromValue(1);
        backBtnFade.setToValue(0);
        backBtnFade.play();

        TranslateTransition boxTransition = new TranslateTransition();
        boxTransition.setDuration(Duration.millis(1000));
        boxTransition.setNode(signInBox);
        boxTransition.setByX(755);
        boxTransition.play();
        TranslateTransition messageTransition = new TranslateTransition();
        messageTransition.setDuration(Duration.millis(1000));
        messageTransition.setNode(message);
        messageTransition.setByX(755);
        messageTransition.play();
        TranslateTransition nextBtnTransition = new TranslateTransition();
        nextBtnTransition.setDuration(Duration.millis(1000));
        nextBtnTransition.setNode(NextBtn);
        nextBtnTransition.setByX(755);
        nextBtnTransition.play();
        TranslateTransition checkBtnTransition = new TranslateTransition();
        checkBtnTransition.setDuration(Duration.millis(1000));
        checkBtnTransition.setNode(checkBtn);
        checkBtnTransition.setByX(650);
        checkBtnTransition.play();
        TranslateTransition backBtnTransition = new TranslateTransition();
        backBtnTransition.setDuration(Duration.millis(1000));
        backBtnTransition.setNode(backBtn);
        backBtnTransition.setByX(650);
        backBtnTransition.play();
        backBtn.setDisable(true);
        checkBtn.setDisable(false);


    }
    Stage stage;
    Scene scene;
    public void signIn(ActionEvent event) throws IOException, ClassNotFoundException {
<<<<<<< Updated upstream
        ArrayList<User> users = Global.getAllUsers();
=======
>>>>>>> Stashed changes
        if(username.getText().equals(Global.currentOwner.getUsername())&&password.getText().equals(Global.currentOwner.getPassword())) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ownerPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setResizable(false);
            Parent root = loader.load();
            scene = new Scene(root, 883, 558);
            stage.setScene(scene);
            stage.show();
        }
<<<<<<< Updated upstream
        else{
            for(User user : users) {
                if(user.getUsername().equals(username.getText())&&user.getPassword().equals(password.getText())) {
                    if(user instanceof Admin) {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPage.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setResizable(false);
                        Parent root = loader.load();
                        scene = new Scene(root, 883, 558);
                        stage.setScene(scene);
                        stage.show();
                        System.out.println("admin");

                    }
                    else if(user instanceof Customer) {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setResizable(false);
                        Parent root = loader.load();
                        scene = new Scene(root, 883, 558);
                        stage.setScene(scene);
                        stage.show();
                        System.out.println("customer");
                    }

                }
            }
        }

=======
>>>>>>> Stashed changes
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void enter(javafx.event.ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("com/example/homepage/hello-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Sign Up");
            stage.setScene(new Scene(root));
            stage.show();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void goToSignUp(javafx.event.ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("com/example/homepage/Signup.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Sign Up");
            stage.setScene(new Scene(root));
            stage.show();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
