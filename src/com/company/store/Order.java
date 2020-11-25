package com.company.store;

import java.util.ArrayList;

public class Order {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    private final String clientName;
    private final ArrayList<Product> clientCartContent;

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public Order(String name, ArrayList<Product> cart) {
        clientName = name;
        clientCartContent = cart;
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    public String getClientName() {
        return clientName;
    }

    public ArrayList<Product> getClientCartContent() {
        return clientCartContent;
    }

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
