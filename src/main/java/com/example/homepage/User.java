package com.example.homepage;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String name;
    private String surname;
    private int age;
    private String gender;
    private String username;
    private String password;
    private Date dateJoined;
    User(String name, String surname, int age, String gender, String username, String password, Date dateJoined) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.dateJoined = dateJoined;

    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getSurname(){
        return surname;
    }
    public void setAge(int age){
        this.age = age;

    }
    public int getAge(){
        return age;
    }
    public void setGender(String gender){
        this.gender = gender;

    }
    public String getGender(){
        return gender;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setDateJoined(Date dateJoined){
        this.dateJoined = dateJoined;
    }
    public Date getDateJoined(){
        return dateJoined;
    }

}
