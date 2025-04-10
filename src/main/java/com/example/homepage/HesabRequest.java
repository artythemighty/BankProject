package com.example.homepage;

import java.util.Date;

public class HesabRequest extends Requests{
    private Customer requester;
    private double interest;

    public HesabRequest(Date requestDate, String description, int requestId,Customer requester, double interest) {
        super(requestDate, description, requestId);

    }

    public Customer getRequester() {
        return requester;
    }
    public void setRequester(Customer requester) {
        this.requester = requester;
    }
    public double getInterest() {
        return interest;
    }
    public void setInterest(double interest) {
        this.interest = interest;
    }

}
