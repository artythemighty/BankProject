package com.example.homepage;

import java.io.Serializable;
import java.util.UUID;

public class LoanRequest implements Serializable {
    private String requestId;
    private String username;
    private int amount;
    private int term;
    private String loanType;
    private boolean isPaid = false;

    public LoanRequest(String username, int amount, int term, String loanType) {
        this.requestId = UUID.randomUUID().toString();
        this.username = username;
        this.amount = amount;
        this.term = term;
        this.loanType = loanType;

    }
    public String getRequestId() {
        return requestId;
    }
    public String getUsername() {
        return username;
    }
    public boolean isPaid(Boolean paid) {
        return isPaid;
    }
}
