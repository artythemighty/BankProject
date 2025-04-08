package com.example.homepage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

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
}
