package com.example.userstorage;

import java.io.Serializable;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String degreeProgram;
    private int icon;

    public User(String firstName, String lastName, String email, String degreeProgram, int icon) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.icon = icon;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public String getDegreeProgram(){
        return degreeProgram;
    }

    public int getIcon(){
        return icon;
    }




}
