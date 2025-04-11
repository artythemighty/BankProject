package com.example.homepage;

import java.io.*;
import java.util.ArrayList;

public class fileHandling {
    public static void writeToFileUsers(ArrayList<User> allUsers) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("Users.dat");
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(Global.getAllUsers());

    }

    public static ArrayList<User> readFromFileUsers() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("Users.dat");
        ObjectInputStream in = new ObjectInputStream(fileInputStream);
        ArrayList<User> allUsers = (ArrayList<User>) in.readObject();
        return allUsers;
    }

    public static void writeToFileRequests() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("Requests.dat");
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(Global.getRequests());
    }

    public static ArrayList<Requests> readFromFileRequests() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("Requests.dat");
        ObjectInputStream in = new ObjectInputStream(fileInputStream);
        ArrayList<Requests> allRequests = (ArrayList<Requests>) in.readObject();
        return allRequests;
    }
}
