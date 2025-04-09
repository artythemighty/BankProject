package com.example.homepage;

import java.util.ArrayList;

public class Owner {
    private ArrayList<Admin> admins;
    private double income;
    public void addAdmin(String name, String surname, int dateOfBirth, String gender, String username, String password){
        Global.getAllAdmins().add(new Admin(name, surname, dateOfBirth, gender, username, password));
    }
}
