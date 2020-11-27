package com.company.user;

public class Client extends User {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    private final Cart myCart;

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public Client(String p_sName, String p_sPassword) {
        myCart=new Cart();
        setName(p_sName);
        setPassword(p_sPassword);
    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    public Cart getMyCart() {

        return myCart;
    }

}
