package com.company.store;

import java.util.ArrayList;

public class Market {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    ArrayList<Product> m_aStore = new ArrayList<>();
    Product baguette = new Product("baguette", 42, 2.0);
    Product pain = new Product("pain", 42, 1.0);


    // -------------------------------------------------
    // constructor
    // -------------------------------------------------


    public Market() {
        m_aStore.add(baguette);
        m_aStore.add(pain);
    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    //Regular getter to get the ArrayList
    public ArrayList<Product> getTheStore() {
        return m_aStore;
    }


}
