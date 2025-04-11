package com.example.homepage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class reportControl implements Initializable {
    private Double expense=0.0;
    private Double income=0.0;
    ArrayList<TransactionClass> transactions=Global.getAllTransactions();
    @FXML
    private TableView<TransactionClass> reportTable;
    @FXML
    private TableColumn<TransactionClass, Date> dateColumn;
    @FXML
    private TableColumn<TransactionClass, String> typeColumn;
    @FXML
    private TableColumn<TransactionClass, Double> amountColumn;
    @FXML
    private TableColumn<TransactionClass, String> senderColumn;
    @FXML
    private TableColumn<TransactionClass, String> receiverColumn;
    @FXML
    private TableColumn<TransactionClass, String> senderAccountColumn;
    @FXML
    private TableColumn<TransactionClass, String> receiverAccountColumn;
    @FXML
    private Label expenseLabel;
    @FXML
    private Label incomeLabel;
    @FXML
    private Label balanceLabel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<TransactionClass,Date>("date"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<TransactionClass,String>("type"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<TransactionClass,Double>("amount"));
        senderColumn.setCellValueFactory(new PropertyValueFactory<TransactionClass,String>("senderName"));
        receiverColumn.setCellValueFactory(new PropertyValueFactory<TransactionClass,String>("receiverName"));
        senderAccountColumn.setCellValueFactory(new PropertyValueFactory<TransactionClass,String>("senderNumber"));
        receiverAccountColumn.setCellValueFactory(new PropertyValueFactory<TransactionClass,String>("receiverNumber"));
        reportTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        for (TransactionClass transactionClass : transactions) {
            if(transactionClass.getReceiver().getUsername().equals(Global.currentUser.getUsername())||((transactionClass.getSender()!=null)&&transactionClass.getSender().getUsername().equals(Global.currentUser.getUsername()))){
                reportTable.getItems().add(transactionClass);
            }
        }
        for (TransactionClass transactionClass : transactions) {
            if (transactionClass.getReceiver().getUsername().equals(Global.currentUser.getUsername())) {
                income+=transactionClass.getAmount();

            }
            else if (transactionClass.getSender().getUsername().equals(Global.currentUser.getUsername())) {
                expense+=transactionClass.getAmount();
            }
        }
        expenseLabel.setText("Total Expenses: $"+expense);
        incomeLabel.setText("Income: $"+income);
        if (income-expense>0) {
            balanceLabel.setText("Balance: +$"+income);
            balanceLabel.setStyle("-fx-text-fill: green;");
        }
        else {
            balanceLabel.setText("Balance: -$"+income);
            balanceLabel.setStyle("-fx-text-fill: red;");
        }


    }
}
