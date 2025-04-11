package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

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
    private Label loanId;


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



    @FXML
    private void submitMortgageLoanRequest() throws IOException, ClassNotFoundException {
        if(Global.currentUser == null){
            System.out.println("You are not logged in");
            return;
        }

        String name = Global.currentUser.getName();
        int amount = (int) amountSlider.getValue();
        int term = (int) termSlider.getValue();
        String loanType = "Mortgage";

        LoanRequest LoanRequest = new LoanRequest(name, amount, term, loanType);
        ArrayList<LoanRequest> allRequests;
        allRequests = fileHandling.readFromFileLoanRequests();
        allRequests=new ArrayList<>();
        allRequests.add(LoanRequest);
        fileHandling.writeToFileLoanRequests(allRequests);
        System.out.println("Saved to file" + LoanRequest.getRequestId());
        loanId.setVisible(true);
        loanId.setStyle("-fx-text-fill: green");
        loanId.setText("Request has been sent.Please remember the ID:"+" "+LoanRequest.getRequestId()+ loanType);
        ArrayList<User> users = Global.getAllUsers();
        for(User user : users) {
            if(user.getUsername().equals(nameField.getText())) {
                continue;
            }
            else {
                loanId.setVisible(true);
                loanId.setText("Username not equal");
                loanId.setStyle("-fx-text-fill: red");
            }
        }

        if(nameField.getText().isEmpty()){
            loanId.setVisible(true);
            loanId.setText("Username is empty");
            loanId.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    private void submitPurchesGoodsLoanRequest() throws IOException, ClassNotFoundException {
        if(Global.currentUser == null){
            System.out.println("You are not logged in");
            return;
        }
        String name = Global.currentUser.getName();
        int amount = (int) amountSlider.getValue();
        int term = (int) termSlider.getValue();
        String loanType = "PurchesGoods";

        LoanRequest LoanRequest = new LoanRequest(name, amount, term, loanType);
        ArrayList<LoanRequest> allRequests;
        allRequests = fileHandling.readFromFileLoanRequests();
        allRequests=new ArrayList<>();
        allRequests.add(LoanRequest);
        fileHandling.writeToFileLoanRequests(allRequests);
        System.out.println("Saved to file" + LoanRequest.getRequestId());
        loanId.setVisible(true);
        loanId.setStyle("-fx-text-fill: green");
        loanId.setText("Request has been sent.Please remember the ID:"+" "+LoanRequest.getRequestId()+ loanType);
        ArrayList<User> users = Global.getAllUsers();
        for(User user : users) {
            if(user.getUsername().equals(nameField.getText())) {
                continue;
            }
            else {
                loanId.setVisible(true);
                loanId.setText("Username not equal");
                loanId.setStyle("-fx-text-fill: red");
            }
        }

        if(nameField.getText().isEmpty()){
            loanId.setVisible(true);
            loanId.setText("Username is empty");
            loanId.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    public void submitQarsAlHasenhLoanRequest() throws IOException, ClassNotFoundException {
        if(Global.currentUser == null){
            System.out.println("You are not logged in");
            return;
        }
        String name = Global.currentUser.getName();
        int amount = (int) amountSlider.getValue();
        int term = (int) termSlider.getValue();
        String loanType = "QarsAlHasenh";

        LoanRequest LoanRequest = new LoanRequest(name, amount, term, loanType);
        ArrayList<LoanRequest> allRequests;
        allRequests = fileHandling.readFromFileLoanRequests();
        allRequests=new ArrayList<>();
        allRequests.add(LoanRequest);
        fileHandling.writeToFileLoanRequests(allRequests);
        System.out.println("Saved to file" + LoanRequest.getRequestId());
        loanId.setVisible(true);
        loanId.setStyle("-fx-text-fill: green");
        loanId.setText("Request has been sent.Please remember the ID:"+" "+LoanRequest.getRequestId()+ loanType);
        ArrayList<User> users = Global.getAllUsers();
        for(User user : users) {
            if(user.getUsername().equals(nameField.getText())) {
                continue;
            }
            else {
                loanId.setVisible(true);
                loanId.setText("Username not equal");
                loanId.setStyle("-fx-text-fill: red");
            }
        }

        if(nameField.getText().isEmpty()){
            loanId.setVisible(true);
            loanId.setText("Username is empty");
            loanId.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    public void submitMarriageLoanRequest() throws IOException, ClassNotFoundException {
        if(Global.currentUser == null){
            System.out.println("You are not logged in");
            return;
        }
        String name = Global.currentUser.getName();
        int amount = (int) amountSlider.getValue();
        int term = (int) termSlider.getValue();
        String loanType = "Marriage";

        LoanRequest LoanRequest = new LoanRequest(name, amount, term, loanType);
        ArrayList<LoanRequest> allRequests;
        allRequests = fileHandling.readFromFileLoanRequests();
        allRequests=new ArrayList<>();
        allRequests.add(LoanRequest);
        fileHandling.writeToFileLoanRequests(allRequests);
        System.out.println("Saved to file" + LoanRequest.getRequestId());
        loanId.setVisible(true);
        loanId.setStyle("-fx-text-fill: green");
        loanId.setText("Request has been sent.Please remember the ID:"+" "+LoanRequest.getRequestId()+ loanType);
        ArrayList<User> users = Global.getAllUsers();
        for(User user : users) {
            if(user.getUsername().equals(nameField.getText())) {
                continue;
            }
            else {
                loanId.setVisible(true);
                loanId.setText("Username not equal");
                loanId.setStyle("-fx-text-fill: red");
            }
        }

        if(nameField.getText().isEmpty()){
            loanId.setVisible(true);
            loanId.setText("Username is empty");
            loanId.setStyle("-fx-text-fill: red");
        }
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
