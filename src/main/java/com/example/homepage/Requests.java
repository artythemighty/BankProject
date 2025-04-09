package com.example.homepage;

import java.util.Date;

public class Requests {
    private Date requestDate;
    private String description;
    private int requestId;
    public Requests(Date requestDate, String description, int requestId) {
        this.requestDate = requestDate;
        this.description = description;
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


}
