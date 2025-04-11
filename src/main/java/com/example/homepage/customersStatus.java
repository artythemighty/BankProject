package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class customersStatus implements Initializable {
    Stage stage;
    Scene scene;
    ArrayList<HesabClass> hesabClasses =Global.currentUser.getHesabs();
    HesabClass selectedHesabClass;
    @FXML
    private AnchorPane choice;
    @FXML
    private TableView<HesabClass> accountsTable;
    @FXML
    private TableColumn<HesabClass, String> numberColumn;
    @FXML
    private TableColumn<HesabClass, Double> balanceColumn;
    @FXML
    private TableColumn<HesabClass, Date> dateColumn;
    @FXML
    private TableColumn<HesabClass, Integer> cvvColumn;
    @FXML
    private Label choiceTitle;
    @FXML
    private Button normalBtn;
    @FXML
    private Button savingsBtn;
    @FXML
    private Button okBtn;
    @FXML
    private Label sentLabel;

    public void requestAccount(ActionEvent event) throws IOException {
        choice.setVisible(true);
    }
    public void requestNormal(ActionEvent event) throws IOException {
        Button bt = (Button) event.getSource();
        HesabRequest hesabRequest = new HesabRequest(new Date(),bt.getText(),Global.currentUser,0.05);
        hesabRequest.setRequesterUsername(Global.currentUser.getUsername());
        hesabRequest.setRequester(Global.currentUser);
        Global.currentUser.getMyRequests().add(hesabRequest);
        Global.getRequests().add(hesabRequest);
        fileHandling.writeToFileRequests();
        fileHandling.writeToFileUsers(Global.getAllUsers());
        System.out.print("sent");
        normalBtn.setVisible(false);
        savingsBtn.setVisible(false);
        choiceTitle.setVisible(false);
        okBtn.setVisible(true);
        sentLabel.setVisible(true);

    }
    public void requestSavings(ActionEvent event) throws IOException {
        Button bt = (Button) event.getSource();
        HesabRequest hesabRequest = new HesabRequest(new Date(),bt.getText(),Global.currentUser,0.2);
        hesabRequest.setRequesterUsername(Global.currentUser.getUsername());
        hesabRequest.setRequester(Global.currentUser);
        Global.currentUser.getMyRequests().add(hesabRequest);
        Global.getRequests().add(hesabRequest);
        fileHandling.writeToFileRequests();
        fileHandling.writeToFileUsers(Global.getAllUsers());
        System.out.print("sent");
        normalBtn.setVisible(false);
        savingsBtn.setVisible(false);
        choiceTitle.setVisible(false);
        okBtn.setVisible(true);
        sentLabel.setVisible(true);

    }
    public void requestConfirm(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("customersStatus.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
    }

    public void backToHomePageFromStatus(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
    }
    public void chargeAccount(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("paymentPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //stage.setResizable(false);
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
        paymentController paymentController = loader.getController();
        paymentController.setHesab(selectedHesabClass);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    selectedHesabClass = accountsTable.getFocusModel().getFocusedItem();
                    System.out.println("focused");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        choice.setVisible(false);
        sentLabel.setVisible(false);
        okBtn.setVisible(false);
        balanceColumn.setCellValueFactory(new PropertyValueFactory<HesabClass,Double>("balance"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<HesabClass,Date>("date"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<HesabClass,String>("number"));
        cvvColumn.setCellValueFactory(new PropertyValueFactory<HesabClass,Integer>("cvv2"));
        accountsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        for (HesabClass hesabClass : hesabClasses) {
            accountsTable.getItems().add(hesabClass);
        }

    }
}
