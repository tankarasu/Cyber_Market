package com.company.user;

public class ClientDatabase extends UserDatabase {

    // -------------------------------------------------
    // constructor
    // -------------------------------------------------

    public ClientDatabase() {
        Client clientOne = new Client("John", "AZERTY1");
        Client clientTwo = new Client("Janet", "QWERTY1");
        getM_aUserList().add(clientOne);
        getM_aUserList().add(clientTwo);
    }

}
