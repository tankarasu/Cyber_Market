package com.company.user;

public class AdminDatabase extends UserDatabase {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    @SuppressWarnings("unused")
    private String m_sName;
    @SuppressWarnings("unused")
    private String m_sPassword;

    // -------------------------------------------------
    // constructor
    // -------------------------------------------------

    public AdminDatabase() {
    }
    public AdminDatabase(Admin admin) {
        getM_aUserList().add(admin);
    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    public String getName() {
        return m_sName;
    }


}
