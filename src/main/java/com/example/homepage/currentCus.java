package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
    Customer focusedCustomer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userNameColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("username"));
        ownerNameColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("name"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("phoneNumber"));
        ArrayList<User> customers = Global.getAllUsers();
        customerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        for (User user : customers) {
            if(user instanceof Customer) {
                customerTable.getItems().add((Customer)user);
            }
        }
        focusedCustomer=customerTable.getFocusModel().getFocusedItem();
    }
    public void fucusUser(ActionEvent event) {
        costumerInfo.setVisible(true);
        name.setText(focusedCustomer.getUsername());
        surname.setText(focusedCustomer.getSurname());
        age.setText(String.valueOf(focusedCustomer.getAge()));
        gender.setText(focusedCustomer.getGender());
        phone.setText(focusedCustomer.getPhoneNumber());
        date.setText(String.valueOf(focusedCustomer.getJoinDate()));
        birthday.setText(String.valueOf(focusedCustomer.getBirthDate()));

    }
    public void closeInfo(ActionEvent event) {
        costumerInfo.setVisible(false);

    }
}
