package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class Transfre {
    HesabClass senderhesab;
    HesabClass receiverhesab;
    ArrayList<User> users=Global.getAllUsers();

    private int currentPass;
    Stage stage;
    Scene scene;
    ArrayList<HesabClass> hesabs = Global.getAllAccounts();
    @FXML
    private Label balanceLabel;
    @FXML
    private Label password;
    @FXML
    private AnchorPane message;
    @FXML
    private TextField sender;
    @FXML
    private TextField receiver;
    @FXML
    private TextField amount;
    @FXML
    private TextField cvv;
    @FXML
    private PasswordField passwordField;

    public void backToHomePageFromTransfer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }
    public void getPassword(ActionEvent event) {
        Random rand = new Random();
        int password1 = rand.nextInt(999)+1000 ;
        password.setText(String.valueOf(password1));
        message.setVisible(true);
        currentPass = password1;
    }
    public void closeMessage(ActionEvent event) {
        message.setVisible(false);
    }
    public void transfer(ActionEvent event) throws IOException {
        boolean senderFound=false;
        boolean receiverFound=false;
        boolean amountFound=false;
        boolean cvvFound=false;
        boolean passwordFound=false;
        for (User user : users) {
            if (user instanceof Customer) {
                ArrayList<HesabClass> hesabs = ((Customer) user).getHesabs();
                for (HesabClass hesab : hesabs) {
                    if (sender.getText().equals(hesab.getNumber())){
                        senderFound=true;
                        senderhesab=hesab;
                    }
                }
            }
        }
        for (User user : users) {
            if (user instanceof Customer) {
                ArrayList<HesabClass> hesabs = ((Customer) user).getHesabs();
                for (HesabClass hesab : hesabs) {
                    if (receiver.getText().equals(hesab.getNumber())){
                        receiverFound=true;
                        receiverhesab=hesab;
                    }
                }
            }
        }
        if (!senderFound) {
            System.out.println("sender not found");
        }
        if (!receiverFound) {
            System.out.println("receiver not found");
        }
        if (senderhesab!=null&&senderhesab.getBalance()>Double.parseDouble(amount.getText())){
            amountFound=true;
        }
        else System.out.println("no amount found");
        if (senderhesab!=null&&senderhesab.getCvv2()==Integer.parseInt(cvv.getText())){
            cvvFound=true;
        }
        else System.out.println("no cvv found");
        if (Integer.parseInt(passwordField.getText())==currentPass){
            passwordFound=true;

        }
        else System.out.println("no password found");
        if (senderFound&&receiverFound&&amountFound&&cvvFound&&passwordFound){
            TransactionClass transactionClass = new TransactionClass((Customer)(receiverhesab.getOwner()),receiverhesab,new Date(),Double.parseDouble(amount.getText()),"transfer");
            transactionClass.setSender((Customer) senderhesab.getOwner());
            transactionClass.setSenderHesab(senderhesab);
            transactionClass.setSenderName(senderhesab.getOwner().getUsername());
            transactionClass.setSenderNumber(senderhesab.getNumber());
            transactionClass.transfer();
            transactionClass.subtract();
            Global.getAllTransactions().add(transactionClass);
            for (User user : users){
                if (user.getUsername().equals(senderhesab.getOwner().getUsername())){
                    if (user instanceof Customer){
                        ArrayList<HesabClass> senderhesabs = ((Customer) senderhesab.getOwner()).getHesabs();
                        ((Customer) user).setHesabs(senderhesabs);
                    }
                }
            }
            for (User user : users){
                if (user.getUsername().equals(receiverhesab.getOwner().getUsername())){
                    if (user instanceof Customer){
                        ArrayList<HesabClass> receiverhesabs = ((Customer) receiverhesab.getOwner()).getHesabs();
                        ((Customer) user).setHesabs(receiverhesabs);

                    }
                }
            }
            Global.setAllUsers(users);
            fileHandling.writeToFileTransactions(Global.getAllTransactions());
            fileHandling.writeToFileUsers(Global.getAllUsers());
            System.out.println("done");
        }


    }

}
