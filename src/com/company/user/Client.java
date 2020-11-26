package com.company.user;

import com.company.store.Market;

public class Client extends User {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    private final Cart myCart;

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public Client(String p_sName, String p_sPassword, Market myMarket) {
        myCart=new Cart(myMarket);
        setName(p_sName);
        setPassword(p_sPassword);
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    public Cart getMyCart() {
        return myCart;
    }

}
