package com.example.homepage;

import java.util.ArrayList;

public class Global {
    private static final Owner owner = new Owner("Amirhossein","Hassanpour",19,"male","Owner","owner1234",10000);
    private static ArrayList<HesabClass> allAccounts = new ArrayList<>();
    private static ArrayList<Requests> requests= new ArrayList<>();
    private static ArrayList<Customer> allCustomers;
    public static Customer currentUser;
    public static Admin currentAdmin;
    public static Owner currentOwner;
    public static ArrayList<TransactionClass> allTransactions= new ArrayList<>();
    private static ArrayList<Admin> allAdmins;
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

    public static ArrayList<HesabClass> getAllAccounts() {
        return allAccounts;
    }

    public static void setAllAccounts(ArrayList<HesabClass> allAccounts) {
        Global.allAccounts = allAccounts;
    }
    public static void setallTransactions(ArrayList<TransactionClass> allTransactions) {
        Global.allTransactions = allTransactions;
    }
    public static ArrayList<TransactionClass> getAllTransactions() {
        return allTransactions;
    }
    public static void showAllAccounts() {
        for (User user : allUsers) {
            if (user instanceof Customer){
                ArrayList<HesabClass> userhesabs=((Customer) user).getHesabs();
                for (HesabClass hesab : userhesabs) {
                    if (!(allAccounts.contains(hesab))) {
                        allAccounts.add(hesab);
                    }
                }

            }
        }
    }
}
