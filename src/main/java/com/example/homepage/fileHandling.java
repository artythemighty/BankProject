package com.example.homepage;

import java.io.*;
import java.util.ArrayList;

public class fileHandling {
    public static void writeToFileUsers() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("Users.dat");
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(Global.getAllUsers());

    }
    public static void readFromFileUsers() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("Users.dat");
        ObjectInputStream in = new ObjectInputStream(fileInputStream);
        Global.setAllUsers((ArrayList<User>) in.readObject());
    }
    public static void writeToFileRequests() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("Requests.dat");
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(Global.getRequests());
    }
    public static void readFromFileRequests() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("Requests.dat");
        ObjectInputStream in = new ObjectInputStream(fileInputStream);
        Global.setRequests((ArrayList<Requests>) in.readObject());
    }
}
