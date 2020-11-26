package com.company.user;

import java.util.ArrayList;

public class UserDatabase {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    private static final ArrayList<User> UserList = new ArrayList<>();
    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public UserDatabase() {
    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    public  ArrayList<User> getM_aUserList() {
        return UserList;
    }

}
