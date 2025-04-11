package com.example.homepage;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

public class TransactionClass implements Serializable {
    private int id;
    private Customer sender;
    private Customer receiver;
    private HesabClass receiverHesab;
    private HesabClass senderHesab;
    private Date date;
    private double amount;
    private String type;
    private String senderName;
    private String receiverName;
    private String receiverNumber;
    private String senderNumber;

    TransactionClass( Customer receiver,HesabClass receiverHesab,Date date,double amount,String type) {
        Random rand = new Random(System.currentTimeMillis());
        this.id=rand.nextInt(1000000000);
        this.receiver = receiver;
        this.receiverHesab = receiverHesab;
        this.date = date;
        this.amount = amount;
        if (sender!=null){
            this.senderName=sender.getUsername();
        }
        this.receiverName = receiver.getUsername();
        if (senderHesab!=null){
            this.senderNumber=senderHesab.getNumber();
        }
        this.receiverNumber=receiverHesab.getNumber();
        this.type=type;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }
    public Customer getSender() {
        return sender;
    }
    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }
    public Customer getReceiver() {
        return receiver;
    }
    public void setReceiverHesab(HesabClass receiverHesab) {
        this.receiverHesab = receiverHesab;
    }
    public HesabClass getReceiverHesab() {
        return receiverHesab;
    }
    public void setSenderHesab(HesabClass senderHesab) {
        this.senderHesab = senderHesab;

    }
    public HesabClass getSenderHesab() {
        return senderHesab;
    }
    public void setDate(Date date) {
        this.date = date;

    }
    public Date getDate() {
        return date;

    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return amount;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void transfer() {
        receiverHesab.setBalance(receiverHesab.getBalance()+amount);
    }
    public void subtract() {
        senderHesab.setBalance(senderHesab.getBalance()-amount);

    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSenderName() {
        return senderName;
    }
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
    public String getReceiverName() {
        return receiverName;
    }
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;

    }
    public String getReceiverNumber() {
        return receiverNumber;
    }
    public void setReceiverNumber(String receiverNumber) {
        this.receiverNumber = receiverNumber;
    }
    public String getSenderNumber() {
        return senderNumber;
    }
    public void setSenderNumber(String senderNumber) {
        this.senderNumber = senderNumber;
    }




}
