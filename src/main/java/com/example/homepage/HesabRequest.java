package com.example.homepage;

import javafx.fxml.Initializable;

import java.io.Serializable;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class HesabRequest extends Requests  {
    private double interest;
    private String requesterUsername;

    public HesabRequest(Date requestDate, String description, int requestId,Customer requester, double interest) {
        super(requestDate, description, requestId);

    }
    public double getInterest() {
        return interest;
    }
    public void setInterest(double interest) {
        this.interest = interest;
    }
    public String getRequesterUsername() {
        return requesterUsername;
    }
    public void setRequesterUsername(String requesterUsername) {
        this.requesterUsername = requesterUsername;
    }

}
