package com.example.homepage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Customer extends User {
    private String email;
    private String phoneNumber;
    private ArrayList<HesabClass> hesabs;
    private ArrayList<Message> userMessages;
    private ArrayList<Requests> myRequests;
    private ArrayList<LoanClass> loans;
    private Date joinDate;
    private LocalDate birthDate;

     Customer(String name, String surname, int dateOfBirth, String gender, String username, String password, Date joinDate, LocalDate birthDate) {
        super(name, surname, dateOfBirth, gender, username, password);
        this.joinDate = joinDate;
        this.birthDate = birthDate;
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
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }


}
