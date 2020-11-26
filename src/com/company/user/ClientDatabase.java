package com.company.user;

import com.company.store.Market;

public class ClientDatabase extends UserDatabase {

    // -------------------------------------------------
    // constructor
    // -------------------------------------------------


    public ClientDatabase() {
        Client clientOne = new Client("John", "AZERTY1");
        getM_aUserList().add(clientOne);
    }

}
