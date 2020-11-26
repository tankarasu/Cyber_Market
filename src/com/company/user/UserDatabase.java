package com.company.user;

import java.io.Serializable;
import java.util.ArrayList;

public class UserDatabase implements Serializable {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    private static ArrayList<User> m_aUserList = new ArrayList<>();
    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public UserDatabase() {
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    public  ArrayList<User> getM_aUserList() {
        return m_aUserList;
    }

    // -------------------------------------------------
    // setters
    // -------------------------------------------------

    public void setM_aUserList(ArrayList<User> m_aUserList) {
        this.m_aUserList = m_aUserList;
    }
}
