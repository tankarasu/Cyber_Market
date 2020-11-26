package com.company.user;

import com.company.store.Market;

public class ClientDatabase extends UserDatabase {

    // -------------------------------------------------
    // constructor
    // -------------------------------------------------

    public ClientDatabase(Market myMarket) {
        Client clientOne = new Client("John", "AZERTY1", myMarket);
        Client clientTwo = new Client("Janet", "QWERTY1", myMarket);
        getM_aUserList().add(clientOne);
        getM_aUserList().add(clientTwo);
    }

}
