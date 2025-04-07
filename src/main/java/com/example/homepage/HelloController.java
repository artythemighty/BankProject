package com.example.homepage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.net.http.WebSocket;
import java.util.EventListener;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
}
