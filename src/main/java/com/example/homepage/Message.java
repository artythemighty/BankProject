package com.example.homepage;

import java.io.Serializable;

public class Message implements Serializable {
    private String message;
    private Customer receiver;
    public Message(String message, Customer receiver) {
        this.message = message;
        this.receiver = receiver;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Customer getReceiver() {
        return receiver;
    }
    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }


}
