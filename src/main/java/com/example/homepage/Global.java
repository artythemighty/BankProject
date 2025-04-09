package com.example.homepage;

import java.util.ArrayList;

public class Global {
    public static long accountCount=0;
    private static ArrayList<Requests> requests;
    private static ArrayList<Customer> allCustomers;
    public static Customer currentUser;
    private static ArrayList<Admin> allAdmins;
    public static int requestCount=0;
    public static ArrayList<Requests> getRequests() {
        return requests;
    }
    public static ArrayList<Customer> getAllCustomers() {
        return allCustomers;
    }
    public static ArrayList<Admin> getAllAdmins() {
        return allAdmins;
    }


}
