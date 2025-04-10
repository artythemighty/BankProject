package com.example.homepage;

import java.util.ArrayList;

public class Global {
    private static final Owner owner = new Owner("Amirhossein","Hassanpour",19,"male","Owner","owner1234");
    private static ArrayList<Requests> requests;
    private static ArrayList<Customer> allCustomers;
    public static Customer currentUser;
    public static Admin currentAdmin;
    public static Owner currentOwner;
    private static ArrayList<Admin> allAdmins;
    public static int requestCount=0;
    private static ArrayList<User> allUsers = new ArrayList<>();
    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }
    public static ArrayList<Requests> getRequests() {
        return requests;
    }
    public static ArrayList<Customer> getAllCustomers() {
        return allCustomers;
    }
    public static ArrayList<Admin> getAllAdmins() {
        return allAdmins;
    }
    public static void setAllUsers(ArrayList<User> allUsers) {
        Global.allUsers = allUsers;
    }
    public static void setRequests(ArrayList<Requests> requests) {
        Global.requests = requests;
    }
    public static void setOwner() {
        Global.currentOwner = owner;
    }
}
