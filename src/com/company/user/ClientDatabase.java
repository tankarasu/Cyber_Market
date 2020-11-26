package com.company.user;

public class ClientDatabase extends UserDatabase {

    // -------------------------------------------------
    // constructor
    // -------------------------------------------------

    public ClientDatabase(){

    }

    public ClientDatabase(Client client) {
        getM_aUserList().add(client);
    }

}
