package com.company.views;

import com.company.store.Market;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Scanner;

public class AdminInterface {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    static Scanner userInput = new Scanner(System.in);
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
            System.out.println("1-List products\n2-Add a Product\n3-Return");
            choice = userInput.next();
            switch (choice) {
                case "1":
                    myMarket.getStore();
                    break;
                case "2":
                    myMarket.addProductMenu();
                    break;
                case "3":
                    Menu.startApp();
                    return;
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
