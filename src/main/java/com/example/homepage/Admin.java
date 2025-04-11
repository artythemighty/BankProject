package com.example.homepage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Admin extends User {
    private ArrayList<Customer> currentCustomers;
    private static final long serialVersionUID = -1310632498429037407l;
    private String adminName;
    private String phoneNumber;
    private String active="Active";

    Admin(String name, String surname, int dateOfBirth, String gender, String username, String password,String phoneNumber) {
        super(name, surname, dateOfBirth, gender, username, password);
        this.adminName = name;
        this.phoneNumber = phoneNumber;
    }

    public void ApproveHesabRequest(HesabRequest request) throws IOException {
        String NewNumber;
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        int firstPart = 10000000+rand.nextInt(90000000);
        int secondPart = 10000000+rand.nextInt(90000000);
        int cvv2=rand.nextInt(9999);
        NewNumber=String.valueOf(firstPart)+String.valueOf(secondPart);
        HesabClass hesab = new HesabClass(request.getRequester(),NewNumber,new Date(),0,request.getInterest(),request.getDescription(),cvv2);
        request.getRequester().addHesab(hesab);
        Global.getAllAccounts().add(hesab);


    }
    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
