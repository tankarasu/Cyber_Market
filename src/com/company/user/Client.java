package com.company.user;

import com.company.store.Market;
import com.company.store.Product;

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
    // méthodes
    // -------------------------------------------------

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    public Cart getMyCart() {
        /*for(Product products:myCart.m_aCart)  {
            System.out.println(products.getName());
        }*/
        return myCart;
    }

}
