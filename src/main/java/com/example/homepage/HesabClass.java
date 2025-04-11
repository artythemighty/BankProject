package com.example.homepage;

import java.io.Serializable;
import java.util.Date;

public class HesabClass implements Serializable {
    private User owner;
    private String number;
    private Date date;
    private double balance;
    private double interestRate;
    private String description;
    HesabClass(User owner, String number, Date dateCreated, double balance, double interestRate, String description) {
        this.owner = owner;
        this.number = number;
        this.date = dateCreated;
        this.balance = balance;
        this.interestRate = interestRate;
        this.description = description;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


}
