package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class adminController implements Initializable {
    @FXML
    private BorderPane border;
    @FXML
    private Button backBtn;
    @FXML
    private Button currentBtn;
    @FXML
    private Button pendingBtn;
    @FXML
    private Button activeLoansBtn;
    @FXML
    private Button adminInfoBtn;
    @FXML
    private ImageView backgroundImg;
    @FXML
    private HBox topBox;
    @FXML
    private ImageView logo;
    Stage stage;
    Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        border.widthProperty().addListener((observable, oldValue, newValue) -> {
            double width = border.getWidth();
            backBtn.setPrefWidth(width/15);
            currentBtn.setPrefWidth(width/5);
            pendingBtn.setPrefWidth(width/5);
            activeLoansBtn.setPrefWidth(width/5);
            adminInfoBtn.setPrefWidth(width/5);
            backgroundImg.setScaleX(width/500);
            logo.setFitWidth(width/4);
            topBox.setSpacing((width/3)+20);
        });
        border.heightProperty().addListener((observable, oldValue, newValue) -> {
            double height = border.getHeight();
            backBtn.setPrefHeight(height/20);
            currentBtn.setPrefHeight(height/2);
            pendingBtn.setPrefHeight(height/2);
            activeLoansBtn.setPrefHeight(height/2);
            adminInfoBtn.setPrefHeight(height/2);
            backgroundImg.setScaleY(height/500);
            logo.setFitHeight(height/4);
            logo.setLayoutY((height/20)-20);
        });


    }
    public void switchToCurrentCustomers(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("currentCus.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPendingRequests(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pendingReq.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToActiveLoans(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("activeLoan.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAdminInfo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("adminInfo.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
    }

    public void backToSigninFromAdmin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("welcomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
    }
}
