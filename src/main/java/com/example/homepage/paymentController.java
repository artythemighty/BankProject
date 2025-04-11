package com.example.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class paymentController implements Initializable {
    HesabClass hesab;
    ArrayList<User> users =Global.getAllUsers();
    ArrayList<TransactionClass> alltransactions =Global.getAllTransactions();

    int code=0;
    @FXML
    private Label paymentcode;
    @FXML
    private TextField numberfield;
    @FXML
    private TextField cvvfield;
    @FXML
    private TextField yearfield;
    @FXML
    private TextField monthfield;
    @FXML
    private TextField dayfield;
    @FXML
    private PasswordField passwordfield;
    @FXML
    private TextField codefield;
    @FXML
    private Text codeerror;
    @FXML
    private Text error;
    @FXML
    private TextField amountf;
    boolean isNumber = false;
    boolean isCvv = false;
    boolean isYear = false;
    boolean isMonth = false;
    boolean isDay = false;
    boolean isPassword = false;
    boolean isCode = false;
    boolean isAmount = true;
    public double amount;
    private Stage stage;
    private Scene scene;



    public void setcode(){
        Random rand = new Random();
        int low = 100000;
        int high = 999999;
        code = rand.nextInt(high-low) + low;
        paymentcode.setText(String.valueOf(code));

    }
    public void setHesab(HesabClass hesab){
        this.hesab = hesab;
    }

    public void checkinfo(ActionEvent event) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if(isPassword&&isNumber&&isCvv&&isYear&&isMonth&&isDay){
            error.setVisible(false);
        }
        if(isNumber&&isDay&&isMonth&&isYear&&isPassword&&isCode&&isCvv&&isAmount){
            hesab.setBalance(hesab.getBalance()+Double.parseDouble(amountf.getText()));
            for (User user : users) {
                if (Objects.equals(user.getUsername(), hesab.getOwner().getUsername())) {
                    if (user instanceof Customer) {
                        ArrayList<HesabClass> hesabClasses = ((Customer) user).getHesabs();
                        for (HesabClass hesabClass : hesabClasses) {
                            if (hesabClass.getNumber()==hesab.getNumber()) {
                                hesabClass.setBalance(hesab.getBalance());
                                ((Customer) user).setHesabs(hesabClasses);
                                fileHandling.writeToFileUsers(Global.getAllUsers());
                            }
                        }
                    }
                }
            }
            ArrayList<HesabClass> allclasses = Global.getAllAccounts();
            for (HesabClass hesabClass : allclasses) {
                if (hesabClass.getNumber()==hesab.getNumber()) {
                    hesabClass.setBalance(hesab.getBalance());
                }
            }
            TransactionClass transactionClass = new TransactionClass(Global.currentUser,hesab,new Date(),Double.parseDouble(amountf.getText()),"Charge");
            alltransactions.add(transactionClass);
            Global.setallTransactions(alltransactions);
            fileHandling.writeToFileTransactions(Global.getAllTransactions());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("customersStatus.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //stage.setResizable(false);
            Parent root = loader.load();
            scene = new Scene(root, 883, 558);
            stage.setScene(scene);
            stage.show();

        }
        else{
            isNumber=true;
            isDay=true;
            isMonth=true;
            isYear=true;
            isPassword=true;
            isCode=true;
            isCvv=true;

        }

        if(codefield.getText().isEmpty()||!(codefield.getText().equals(paymentcode.getText()))){
            codeerror.setVisible(true);
            Random rand = new Random();
            int low = 100000;
            int high = 999999;
            code = rand.nextInt(high-low) + low;
            paymentcode.setText(String.valueOf(code));
            isCode = false;



        }
        else
            codeerror.setVisible(false);

        for(int i = numberfield.getText().length()-1;i>-1;i--){
            if(!(numberfield.getText().charAt(i)>='0'&&numberfield.getText().charAt(i)<='9')){
                isNumber = false;

            }
        }
        for(int i = amountf.getText().length()-1;i>-1;i--){
            if(!(amountf.getText().charAt(i)>='0'&&amountf.getText().charAt(i)<='9')){
                isAmount = false;

            }
        }

        for(int i = yearfield.getText().length()-1;i>-1;i--){
            if(!(yearfield.getText().charAt(i)>='0'&&yearfield.getText().charAt(i)<='9')){
                isYear = false;

            }
        }
        for(int i = monthfield.getText().length()-1;i>-1;i--){
            if(!(monthfield.getText().charAt(i)>='0'&&monthfield.getText().charAt(i)<='9')){
                isMonth = false;

            }
        }
        for(int i = dayfield.getText().length()-1;i>-1;i--){
            if(!(dayfield.getText().charAt(i)>='0'&&dayfield.getText().charAt(i)<='9')){
                isDay = false;

            }
        }



        for(int i = cvvfield.getText().length()-1;i>-1;i--){
            if(!(cvvfield.getText().charAt(i)>='0'&&cvvfield.getText().charAt(i)<='9')){
                isCvv = false;

            }
        }

        if(passwordfield.getText().isEmpty()||passwordfield.getText().length()!=4){
            error.setVisible(true);
            isPassword = false;
            error.setText("Password must be 4 digits");
        }
        if (!isCvv||cvvfield.getText().isEmpty()){
            error.setVisible(true);
            error.setText("Please enter a valid cvv");
        }
        if(!isDay||dayfield.getText().isEmpty()||Integer.parseInt(dayfield.getText())>31){
            error.setVisible(true);
            error.setText("Please enter a valid date");
        }
        if(!isMonth ||monthfield.getText().isEmpty()||Integer.parseInt(monthfield.getText())>12){
            error.setVisible(true);
            error.setText("Please enter a valid date");
        }
        if(!isYear){
            error.setVisible(true);
            error.setText("Please enter a valid date");
        }
        if(!(isNumber&&numberfield.getText().length()==12)){
            error.setVisible(true);
            error.setText("Please enter a valid card number");

        }
        if (!isAmount){
            error.setVisible(true);
            error.setText("Please enter a valid amount");
        }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Random rand = new Random();
        int low = 100000;
        int high = 999999;
        code = rand.nextInt(high-low) + low;
        paymentcode.setText(String.valueOf(code));


    }
}
