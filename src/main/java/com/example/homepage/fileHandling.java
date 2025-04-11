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
    public static ArrayList<LoanRequest> readFromFileLoanRequests() throws IOException, ClassNotFoundException {
        File file = new File("Requests.dat");

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream in = new ObjectInputStream(fileInputStream)) {
            return (ArrayList<LoanRequest>) in.readObject();
        } catch (EOFException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void writeToFileLoanRequests(ArrayList<LoanRequest> loanRequests) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("Requests.dat");
             ObjectOutputStream out = new ObjectOutputStream(fileOutputStream)) {
            out.writeObject(loanRequests);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
