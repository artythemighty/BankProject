package com.example.homepage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Customer extends User {
    private String email;
    private ArrayList<HesabClass> hesabs;
    private ArrayList<Message> userMessages;
    private ArrayList<Requests> myRequests;

    Customer(String name, String surname, int dateOfBirth, String gender, String username, String password) {
        super(name, surname, dateOfBirth, gender, username, password);
    }

    public void RequestHesab(String description,double interest){
        myRequests.add(new HesabRequest(new Date(),description,Global.requestCount,this,interest));
        Global.getRequests().add(new HesabRequest(new Date(),description,Global.requestCount,this,interest));


    }
    public ArrayList<HesabClass> getHesabs() {
        return hesabs;
    }
    public void addHesab(HesabClass hesab) {
        hesabs.add(hesab);
    }

}
