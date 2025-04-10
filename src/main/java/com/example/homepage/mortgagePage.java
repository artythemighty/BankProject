package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class mortgagePage {
    @FXML
    private TextField nameField;

    @FXML
    private Slider amountSlider;

    @FXML
    private Slider termSlider;

    @FXML
    private Label amountLabel;

    @FXML
    private Label termLabel;


    @FXML
    public void initialize() {
        amountLabel.setText("$" + (int) amountSlider.getValue());
        termLabel.setText((int) termSlider.getValue() + " months");

        amountSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            amountLabel.setText("$" + newVal.intValue());
        });

        termSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            termLabel.setText(newVal.intValue() + " months");
        });
    }

    Stage stage;
    Scene scene;

    public void backToLoanPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loan.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();

    }

    public void backToLoanPageFromMortgage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loan.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
    }

    public void backToLoanPageFromQars(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loan.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
    }

    public void backToLoanPageFromRequest(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loan.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
    }

}
