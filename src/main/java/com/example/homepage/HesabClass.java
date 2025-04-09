package com.example.homepage;

import java.util.Date;

public class HesabClass {
    private User owner;
    private long number;
    private Date dateCreated;
    private double balance;
    private double interestRate;
    private String description;
    HesabClass(User owner, long number, Date dateCreated, double balance, double interestRate, String description) {
        this.owner = owner;
        this.number = number;
        this.dateCreated = dateCreated;
        this.balance = balance;
        this.interestRate = interestRate;
        this.description = description;
    }
    private Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
    public long getNumber() {
        return number;
    }
    public void setNumber(int number) {
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
