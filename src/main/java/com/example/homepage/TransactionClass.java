package com.example.homepage;

import java.util.Date;
import java.util.Random;

public class TransactionClass {
    private int id;
    private Customer sender;
    private Customer receiver;
    private HesabClass receiverHesab;
    private HesabClass senderHesab;
    private Date date;
    private double amount;

    TransactionClass(int id, Customer sender,Customer receiver,HesabClass receiverHesab,HesabClass senderHesab,Date date,double amount) {
        Random rand = new Random(System.currentTimeMillis());
        this.id=rand.nextInt(1000000000);
        this.sender = sender;
        this.receiver = receiver;
        this.receiverHesab = receiverHesab;
        this.senderHesab = senderHesab;
        this.date = date;
        this.amount = amount;
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


}
