package com.example.homepage;

import java.io.Serializable;
import java.util.Date;

public class LoanClass implements Serializable {
    private int amount;
    private double interestRate;
    private Date aquisitionDate;
    private int timeToPay;
    private String id;


}
