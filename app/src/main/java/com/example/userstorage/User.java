package com.example.userstorage;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String degreeProgram;
    private int icon;
    private ArrayList<String> degrees = new ArrayList<>();

    public User(String firstName, String lastName, String email, String degreeProgram, int icon, ArrayList<String> degrees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.icon = icon;
        this.degrees = degrees;
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

    public ArrayList<String> getDegrees() {
        return degrees;
    }
}
