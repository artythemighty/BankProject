package com.example.homepage;

import java.util.ArrayList;
import java.util.Date;

public class Admin extends User {
    private ArrayList<Customer> currentCustomers;

    Admin(String name, String surname, int dateOfBirth, String gender, String username, String password) {
        super(name, surname, dateOfBirth, gender, username, password);
    }

    public void ApproveHesabRequest(HesabRequest request) {
        request.getRequester().addHesab(new HesabClass(request.getRequester(),Global.accountCount+1000000000,new Date(),0,request.getInterest(),request.getDescription()));


    }

}
