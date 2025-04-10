package com.example.homepage;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

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
}
