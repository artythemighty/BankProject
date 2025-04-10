package com.example.homepage;

import java.util.ArrayList;
import java.util.Date;

public class Owner extends User{
    private ArrayList<Admin> admins;
    private double income;

    Owner(String name, String surname, int dateOfBirth, String gender, String username, String password, Date date) {
        super(name, surname, dateOfBirth, gender, username, password,date);
    }

    public void addAdmin(String name, String surname, int dateOfBirth, String gender, String username, String password,Date date) {
        Global.getAllAdmins().add(new Admin(name, surname, dateOfBirth, gender, username, password,date));
    }
}
