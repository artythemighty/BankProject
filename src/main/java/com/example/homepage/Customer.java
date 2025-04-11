package com.example.homepage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Customer extends User {
    private String email;
    private String phoneNumber;
    private ArrayList<HesabClass> hesabs= new ArrayList<>();
    private ArrayList<Message> userMessages=new ArrayList<>();
    private ArrayList<Requests> myRequests= new ArrayList<>();
    private ArrayList<LoanClass> loans;
    private Date joinDate;
    private LocalDate birthDate;
    private String active="Active";
    private boolean newmessage=false;

     Customer(String name, String surname, int dateOfBirth, String gender, String username, String password, Date joinDate, LocalDate birthDate,String phoneNumber) {
        super(name, surname, dateOfBirth, gender, username, password);
        this.joinDate = joinDate;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
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
    public Date getJoinDate() {
         return joinDate;
    }
    public void setJoinDate(Date joinDate) {
         this.joinDate = joinDate;
    }
    public LocalDate getBirthDate() {
         return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
         this.birthDate = birthDate;
    }


    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
    public ArrayList<Requests> getMyRequests() {
         return myRequests;
    }
    public void setMyRequests(ArrayList<Requests> myRequests) {
         this.myRequests = myRequests;
    }
    public ArrayList<LoanClass> getLoans() {
         return loans;

    }
    public void setLoans(ArrayList<LoanClass> loans) {
         this.loans = loans;
    }

    public boolean isNewmessage() {
        return newmessage;
    }

    public void setNewmessage(boolean newmessage) {
        this.newmessage = newmessage;
    }

    public ArrayList<Message> getUserMessages() {
        return userMessages;
    }

    public void setUserMessages(ArrayList<Message> userMessages) {
        this.userMessages = userMessages;
    }
}
