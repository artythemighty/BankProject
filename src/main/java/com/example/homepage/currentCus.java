package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class currentCus implements Initializable {
    @FXML
    private TableView<Customer> customerTable;
    @FXML
    private TableColumn<Customer,String> userNameColumn;
    @FXML
    private TableColumn<Customer,String> ownerNameColumn;
    @FXML
    private TableColumn<Customer,String> phoneNumberColumn;
    @FXML
    private TableColumn<Customer, String> statusColumn;
    @FXML
    private Label name;
    @FXML
    private Label surname;
    @FXML
    private Label age;
    @FXML
    private Label gender;
    @FXML
    private Label email;
    @FXML
    private Label phone;
    @FXML
    private Label date;
    @FXML
    private HBox emailBox;
    @FXML
    private Label birthday;
    @FXML
    private VBox costumerInfo;
    @FXML
    private Button suspendBtn;
    @FXML
    private Button activate;
    @FXML
    private Button suspend;
    Customer focusedCustomer;
    ArrayList<User> customers=Global.getAllUsers();
    Stage stage;
    Scene scene;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        costumerInfo.setVisible(false);
        userNameColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("username"));
        ownerNameColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("name"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("phoneNumber"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("active"));
        customerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        for (User user : customers) {
            if(user instanceof Customer) {
                customerTable.getItems().add((Customer)user);
            }
        }
        focusedCustomer=customerTable.getFocusModel().getFocusedItem();
    }
    public void fucusUser(ActionEvent event) throws IOException {
        focusedCustomer=customerTable.getFocusModel().getFocusedItem();
        costumerInfo.setVisible(true);
        name.setText(focusedCustomer.getUsername());
        surname.setText(focusedCustomer.getSurname());
        age.setText(String.valueOf(focusedCustomer.getAge()));
        gender.setText(focusedCustomer.getGender());
        phone.setText(focusedCustomer.getPhoneNumber());
        date.setText(String.valueOf(focusedCustomer.getJoinDate()));
        birthday.setText(String.valueOf(focusedCustomer.getBirthDate()));
        setSuspendBtn();

    }
    public void closeInfo(ActionEvent event) {
        costumerInfo.setVisible(false);

    }
    public void setSuspendBtn() throws IOException {
        if(focusedCustomer!=null) {
            if (focusedCustomer.getActive().equals("Suspended")) {
                suspendBtn.setText("Activate");
                suspendBtn.setStyle("-fx-background-color: #49e6c9");
                suspendBtn.setOnAction(activate.getOnAction());
            }
            else {
                suspendBtn.setText("Suspend");
                suspendBtn.setStyle("-fx-background-color: red");
                suspendBtn.setOnAction(suspend.getOnAction());
            }
        }
    }
    public void suspendCustomer(ActionEvent event) throws IOException {
        for (User user : customers) {
            if(user instanceof Customer) {
                if (user.getUsername().equals(focusedCustomer.getUsername())) {
                    ((Customer) user).setActive("Suspended");
                    fileHandling.writeToFileUsers(customers);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("currentCus.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setResizable(false);
                    Parent root = loader.load();
                    scene = new Scene(root, 883, 558);
                    stage.setScene(scene);
                    stage.show();

                }
            }
        }


    }
    public void activateCustomer(ActionEvent event) throws IOException {
        for (User user : customers) {
            if(user instanceof Customer) {
                if (user.getUsername().equals(focusedCustomer.getUsername())) {
                    ((Customer) user).setActive("Active");
                    fileHandling.writeToFileUsers(customers);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("currentCus.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setResizable(false);
                    Parent root = loader.load();
                    scene = new Scene(root, 883, 558);
                    stage.setScene(scene);
                    stage.show();
                }
            }
        }
    }
}
