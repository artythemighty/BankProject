package com.example.homepage;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class loanControl {
    @FXML
    private Slider loanAmountSlider;
    @FXML
    private Slider repaymentSlider;
    @FXML
    private Label loanAmountLabel;
    @FXML
    private Label repymentTimeLabel;

    @FXML
    private void initialize() {
        loanAmountSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            long amount = Math.round(newValue.doubleValue());
            loanAmountLabel.setText(String.format("%,d $", amount));
        });
        repaymentSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            int month = (int) Math.round(newValue.doubleValue());
            repymentTimeLabel.setText(String.format("%d months", month));
        });

        loanAmountLabel.setText(String.format("%,d $",Math.round(loanAmountSlider.getValue())));
        repymentTimeLabel.setText((int) repaymentSlider.getValue() + "months");
    }
}
