package com.company.user;

import com.company.store.Product;

import java.util.ArrayList;

public class ClientDatabase extends UserDatabase {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
//    private final ArrayList<Client> m_aUserList = new ArrayList<>();
    // todo est ce que le final gène ?

    // -------------------------------------------------
    // constructor
    // -------------------------------------------------

    public ClientDatabase() {
        Client clientOne = new Client("John", "AZERTY1");
        Client clientTwo = new Client("Janet", "QWERTY1");
        getM_aUserList().add(clientOne);
        getM_aUserList().add(clientTwo);
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    // -------------------------------------------------
    // getters
    // -------------------------------------------------


    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
