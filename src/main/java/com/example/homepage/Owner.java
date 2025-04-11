package com.example.homepage;

import java.util.ArrayList;
import java.util.Date;

public class Owner extends User{
    private ArrayList<Admin> admins;
    private double income;
    private double balance;

    Owner(String name, String surname, int age, String gender, String username, String password,double balance) {
        super(name, surname, age, gender, username, password);
        this.balance = balance;
    }

    public void addAdmin(String name, String surname, int dateOfBirth, String gender, String username, String password,Date date,String Phone) {
        Global.getAllAdmins().add(new Admin(name, surname, dateOfBirth, gender, username, password, Phone));
    }
}
