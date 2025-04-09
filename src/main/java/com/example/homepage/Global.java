package com.example.homepage;

import java.util.ArrayList;

public class Global {
    private static ArrayList<Requests> requests;
    private static ArrayList<Customer> allCustomers;
    public static User currentUser;
    private static ArrayList<Admin> allAdmins;
    public static int requestCount=0;
    private static ArrayList<User> allUsers;
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
}
