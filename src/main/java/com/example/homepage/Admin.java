package com.example.homepage;

import java.util.ArrayList;

public class Admin extends User {
    private String[] admins={"admin","admin1","admin2","admin3","admin4","admin5"};
    private String adminKey="admin1234";
    private ArrayList<Costumer> currentCostumers;
    private ArrayList<Costumer> pendingCostumers;
    public String[] getAdmins() {
        return admins;
    }
    public String getAdminKey() {
        return adminKey;
    }
    public ArrayList<Costumer> getCurrentCostumers() {
        return currentCostumers;
    }
    public ArrayList<Costumer> getPendingCostumers() {
        return pendingCostumers;
    }
    public void setcurrentCostumers(Costumer requestedCostumer) {
        currentCostumers.add(requestedCostumer);
    }
    public void setpendingCostumers(Costumer requestedCostumer) {
        pendingCostumers.add(requestedCostumer);
    }
}
