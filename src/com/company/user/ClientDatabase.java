package com.company.user;

import com.company.store.Product;

import java.util.ArrayList;

public class ClientDatabase {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    private final ArrayList<Client> m_aClientList = new ArrayList<>();
    // todo est ce que le final gène ?

    // -------------------------------------------------
    // constructor
    // -------------------------------------------------

    public ClientDatabase() {
        Client clientOne = new Client("John", "AZERTY1");
        Client clientTwo = new Client("Janet", "QWERTY1");
        getClientList().add(clientOne);
        getClientList().add(clientTwo);
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    public ArrayList<Client> getClientList() {
        return m_aClientList;
    }

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
