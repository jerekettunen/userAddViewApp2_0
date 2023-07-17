package com.example.userstorage;

import java.util.ArrayList;

public class UserStorage {
    private ArrayList<User> users = new ArrayList<User>();

    private static  UserStorage singleton = null;

    private UserStorage() {

    }
    public static UserStorage getInstance() {
        if (singleton == null){
            singleton = new UserStorage();
        }
        return singleton;
    }

    public void addUser (User user){
        users.add(user);
    }

    public void removeUser (int id){
        users.remove(id);
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
