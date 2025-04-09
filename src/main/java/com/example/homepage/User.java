package com.example.homepage;

public class User {
    private String name;
    private String surname;
    private int dateOfBirth;
    private String gender;
    private String username;
    private String password;
    User(String name, String surname, int dateOfBirth, String gender, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.username = username;
        this.password = password;

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
    public void setDateOfBirth(int dateOfBirth){
        this.dateOfBirth = dateOfBirth;

    }
    public int getDateOfBirth(){
        return dateOfBirth;
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

}
