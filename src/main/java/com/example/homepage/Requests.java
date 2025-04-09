package com.example.homepage;

import java.util.Date;

public class Requests {
    private Date requestDate;
    private String description;
    private long requestId;
    public Requests(Date requestDate, String description, long requestId) {
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
