package com.example.homepage;

import java.util.Date;

public class Costumer extends User{
    private int accountId;
    private Date dateOfJoining;
    private int balance;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
    private Boolean accountCreated=false;
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public Date getDateOfJoining() {
        return dateOfJoining;
    }
    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
    public int getBalance() {
        return balance;

    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean getAccountCreated() {
        return accountCreated;
    }
    public void setAccountCreated(Boolean accountCreated) {
        this.accountCreated = accountCreated;
    }

}
