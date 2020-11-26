package com.company.store;

import com.company.Main;

import java.io.Serializable;
import java.util.ArrayList;

public class Market implements Serializable {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    ArrayList<Product> m_aStore = new ArrayList<>();

    // -------------------------------------------------
    // constructor
    // -------------------------------------------------


    public Market() {
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    public void addProduct(String p_sProductName, double p_dProductPrice, int p_iQuantity) {
            getTheStore().add(new Product(p_sProductName, p_iQuantity, p_dProductPrice));
            System.out.println("Product added");
    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    //Regular getter to get the ArrayList
    public ArrayList<Product> getTheStore() {
        return m_aStore;
    }


}
