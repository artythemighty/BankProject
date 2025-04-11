package com.example.homepage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("welcomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 883, 558);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("HomePage");
        stage.setScene(scene);
        stage.show();
       //stage.setResizable(false);
        stage.setMinHeight(595);
        stage.setMinWidth(883);
        Global.setOwner();
        Global.setAllUsers(fileHandling.readFromFileUsers());
        Global.setRequests(fileHandling.readFromFileRequests());
        Global.showAllAccounts();
        Global.setallTransactions(fileHandling.readFromFileTransactions());
        System.out.println(Global.getAllTransactions().size());


    }

    public static void main(String[] args) {
        launch();
    }
    
}