package com.example.userstorage;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Locale;

public class UserStorage {
    final private String FILENAME = "User_Data";

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
        // Always sorting the users by LastName when adding
        sortUsers();
    }

    public void removeUser (int id){
        users.remove(id);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void sortUsers() {
        // using a lambda function where it compares the value LastNames and sorts accordingly
        users.sort( (a, b) -> a.getLastName().toUpperCase().compareTo(b.getLastName().toUpperCase()));
    }

    public void saveUsers(Context context){
        try{
            ObjectOutputStream dataWriter = new ObjectOutputStream(context.openFileOutput(FILENAME,context.MODE_PRIVATE));
            dataWriter.writeObject(users);
            dataWriter.close();

        } catch(IOException e){
            System.out.println("Virhe tallennuksessa");
        }
    }

    @SuppressWarnings("unchecked")
    public void loadUsers(Context context) {
        try {
            ObjectInputStream dataReader = new ObjectInputStream(context.openFileInput(FILENAME));
            users = (ArrayList<User>) dataReader.readObject();
            dataReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei ole vielä olemassa");
        } catch (IOException e) {
            System.out.println("Tietojen lukeminen ei onnistunut");
        } catch (ClassNotFoundException e) {
            System.out.println("Tietojen lukeminen ei onnistunut");
        }
    }
}
