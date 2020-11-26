package com.company.user;

import java.io.Serializable;

public class User implements Serializable {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    private String m_sName;
    private String m_sPassword;
    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public User() {

    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    // public void choiceMenu
    // todo repenser à la refacto

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    public String getName() {
        return m_sName;
    }

    public String getPassword() {
        return m_sPassword;
    }


    // -------------------------------------------------
    // setters
    // -------------------------------------------------


    public void setName(String m_sName) {
        this.m_sName = m_sName;
    }

    public void setPassword(String m_sPassword) {
        this.m_sPassword = m_sPassword;
    }

    public Cart getMyCart() {
        return null;
    }
}
