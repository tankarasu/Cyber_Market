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
    public static void isAdminRegistered(){
        System.out.println("Your are registred");
        AdminInterface.ChoiceMenu();
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
