package com.company.user;

import com.company.store.Market;

public class ClientDatabase extends UserDatabase {

    // -------------------------------------------------
    // constructor
    // -------------------------------------------------

    public ClientDatabase(Client client) {
        getM_aUserList().add(client);
    }

}
