package com.company.views;

import com.company.Main;
import com.company.store.Market;

public class AdminInterface {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public AdminInterface() {

    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------


    public static void ChoiceMenu(Market myMarket) {
        String choice;
        do {
            System.out.println("What do you want to do ?");
            System.out.println("1-List products\n2-Add a Product\n3-Return\n4-Display Orders");
            choice = Main.getInput();
            switch (choice) {
                case "1":
                    myMarket.getProductList();
                    break;
                case "2":
                    myMarket.addProductMenu();
                    break;
                case "3":
                   // Menu.startApp();
                    return;
                case "4":
                    break;
            }
            choice="";
        } while (!choice.equalsIgnoreCase("1") & !choice.equalsIgnoreCase("2") & !choice.equalsIgnoreCase("3"));
    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
