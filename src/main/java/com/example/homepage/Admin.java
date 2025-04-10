package com.example.homepage;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Admin extends User {
    private ArrayList<Customer> currentCustomers;

    Admin(String name, String surname, int dateOfBirth, String gender, String username, String password) {
        super(name, surname, dateOfBirth, gender, username, password);
    }

    public void ApproveHesabRequest(HesabRequest request) {
        String NewNumber;
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        int firstPart = 10000000+rand.nextInt(90000000);
        int secondPart = 10000000+rand.nextInt(90000000);
        NewNumber=String.valueOf(firstPart)+String.valueOf(secondPart);
        request.getRequester().addHesab(new HesabClass(request.getRequester(),NewNumber,new Date(),0,request.getInterest(),request.getDescription()));


    }

}
