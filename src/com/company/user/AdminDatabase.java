package com.company.user;

import java.util.ArrayList;

public class AdminDatabase extends UserDatabase {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    private String m_sName;
    private String m_sPassword;
//    private static final ArrayList<Admin> m_aUserList = new ArrayList<>();

    // todo est ce que le final gène ?

    // -------------------------------------------------
    // constructor
    // -------------------------------------------------

    public AdminDatabase() {
        Admin admin = new Admin();
        admin.setPassword("Root");
        admin.setName("Admin");
        getM_aUserList().add(admin);
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

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


}
