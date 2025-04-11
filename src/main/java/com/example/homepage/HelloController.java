package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private BorderPane border;
    @FXML
    private Button chargeBtn;
    @FXML
    private Button reportBtn;
    @FXML
    private Button billBtn;
    @FXML
    private Button loanBtn;
    @FXML
    private Button transferBtn;
    @FXML
    private HBox buttonBox;
    @FXML
    private Button homeBtn;
    @FXML
    private Button walletBtn;
    @FXML
    private Button profileBtn;
    @FXML
    private AnchorPane anchor;
    @FXML
    private HBox bar;
    @FXML
    private ImageView chargeImg;
    @FXML
    private ImageView reportImg;
    @FXML
    private ImageView billImg;
    @FXML
    private ImageView loanImg;
    @FXML
    private ImageView transferImg;
    @FXML
    private ImageView background;
    @FXML
    private ImageView profileImg;
    @FXML
    private Circle alert;
    Stage stage;
    Scene scene;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Global.currentUser.isNewmessage())
            alert.setVisible(true);
        else
            alert.setVisible(false);
        if (Global.currentUser!=null&&Global.currentUser.getGender().equals("female")) {
            profileImg.setImage(new Image("D:\\BankProject\\BankProject\\src\\main\\resources\\com\\example\\homepage\\female icon.png"));
        }
        border.widthProperty().addListener((observable, oldValue, newValue) -> {
            double width = border.getWidth();
            chargeBtn.setPrefWidth(width/8);
            reportBtn.setPrefWidth(width/8);
            billBtn.setPrefWidth(width/8);
            loanBtn.setPrefWidth(width/8);
            transferBtn.setPrefWidth(width/8);
            homeBtn.setPrefWidth(width/3);
            walletBtn.setPrefWidth(width/3);
            profileBtn.setPrefWidth(width/3);
            chargeImg.setFitWidth(width/8);
            reportImg.setFitWidth(width/8);
            billImg.setFitWidth(width/8);
            loanImg.setFitWidth(width/8);
            transferImg.setFitWidth(width/8);
            background.setScaleX(width/600);



        });
        border.heightProperty().addListener((observable, oldValue, newValue) -> {
            double height = border.getHeight();
            homeBtn.setPrefHeight(height/5);
            walletBtn.setPrefHeight(height/5);
            profileBtn.setPrefHeight(height/5);
            bar.setPrefHeight(height/5);
            chargeBtn.setPrefHeight(height/6);
            reportBtn.setPrefHeight(height/6);
            billBtn.setPrefHeight(height/6);
            loanBtn.setPrefHeight(height/6);
            transferBtn.setPrefHeight(height/6);
            buttonBox.setPrefHeight(height/6);
            chargeImg.setFitHeight(height/6);
            reportImg.setFitHeight(height/6);
            billImg.setFitHeight(height/6);
            loanImg.setFitHeight(height/6);
            transferImg.setFitHeight(height/6);
            background.setScaleY(height/550);

        });
    }
    public void switchToProfile(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profilePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public void switchToLoan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loan.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public void switchToTransfer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("transferSelection.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public void switchToCharge(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("charge.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public void switchToReport(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("report.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public void switchToBill(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("bill.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public void switchToAccountsStatus(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("customersStatus.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public void switchToStatus(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("customersStatus.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }

    public void switchToMyRequests(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("myRequests.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }
}
