package com.company.views;

import com.company.store.Market;

public class Auth {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------


    public Auth() {
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------
    public static void isAdminRegistered(Market myMarket){
        System.out.println("Your are registered");
        AdminInterface.ChoiceMenu(myMarket);
    }

    public static void isClientRegistered(Market myMarket){
        System.out.println("Your are registred");
        ClientInterface.ChoiceMenu(myMarket);
    }

    public static void createAccount() {
        System.out.println("Account created");
    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
