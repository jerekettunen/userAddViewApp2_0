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
    }

    public void removeUser (int id){
        users.remove(id);
    }

    public ArrayList<User> getUsers() {
        return users;
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
            try {
                new File(FILENAME).createNewFile();
            } catch (IOException ex) {
                System.out.println("Uuden tiedoston luominen ei onnistunut");
            }
        } catch (IOException e) {
            System.out.println("Tietojen lukeminen ei onnistunut");
        } catch (ClassNotFoundException e) {
            System.out.println("Tietojen lukeminen ei onnistunut");
        }
    }
}
