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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class adminListControll implements Initializable {

    ArrayList<User> admins=Global.getAllUsers();

    Stage stage;
    Scene scene;
    @FXML
    private TableView<Admin> adminTable;
    @FXML
    private TableColumn<Admin , String> ownerNameColumn;
    @FXML
    private TableColumn<Admin , String> adminNameColumn;
    @FXML
    private TableColumn<Admin , String> phoneNumberColumn;
    @FXML
    private VBox adminInfo;
    @FXML
    private Label name;
    @FXML
    private Label surname;
    @FXML
    private Label age;
    @FXML
    private Label gender;
    @FXML
    private Label phoneNumber;
    Admin focusedAdmin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminInfo.setVisible(false);
        ownerNameColumn.setCellValueFactory(new PropertyValueFactory<Admin ,String>("username"));
        adminNameColumn.setCellValueFactory(new PropertyValueFactory<Admin ,String>("adminName"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Admin ,String>("phoneNumber"));
        adminTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        for (User user : admins ){
            if(user instanceof Admin){
                Admin admin = (Admin) user;
                adminTable.getItems().add(admin);
            }
        }
        focusedAdmin=adminTable.getFocusModel().getFocusedItem();
    }

    public void fucusAdminUser(ActionEvent event) throws IOException{
        focusedAdmin=adminTable.getFocusModel().getFocusedItem();
        adminInfo.setVisible(true);
        name.setText(focusedAdmin.getUsername());
        surname.setText(focusedAdmin.getAdminName());
        age.setText(String.valueOf(focusedAdmin.getAge()));
        gender.setText(focusedAdmin.getGender());
        phoneNumber.setText(focusedAdmin.getPhoneNumber());
        adminInfo.setVisible(true);
    }
    public void removeAdmin(ActionEvent event) throws IOException{
        Global.getAllUsers().remove(focusedAdmin);
        adminTable.getItems().remove(focusedAdmin);
        fileHandling.writeToFileUsers(Global.getAllUsers());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("adminList.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
    }

    public void closeInfo(ActionEvent event) throws IOException{
        adminInfo.setVisible(false);
    }

    public void backToOwnerPageFromAdminList(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ownerPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Parent root = loader.load();
        scene = new Scene(root, 883, 558);
        stage.setScene(scene);
        stage.show();
    }

}
