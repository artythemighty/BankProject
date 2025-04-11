package com.example.homepage;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

public class Requests implements Serializable {
    private Date requestDate;
    private String description;
    private int requestId;
    private String status = "pending";
    private Customer requester;
    public Requests(Date requestDate, String description, int requestId) {
        Random rand = new Random(System.currentTimeMillis());
        this.requestDate = requestDate;
        this.description = description;
        requestId=rand.nextInt(1000000000);
        this.requestId = requestId;

    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
    public Date getRequestDate() {
        return requestDate;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
    public int getRequestId() {
        return requestId;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
    public void setRequester(Customer requester) {
        this.requester = requester;
    }
    public Customer getRequester() {
        return requester;
    }




}
