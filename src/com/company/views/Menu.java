package com.company.views;

import com.company.store.Market;

import java.util.Scanner;

public class Menu {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    static Scanner userInput = new Scanner(System.in);

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    public static void launchApp() {

        System.out.println("-------------------------");
        System.out.println("Bienvenue au Cyber Market");
        System.out.println("-------------------------");

        // choix du rôle de l'utilisateur
        chooseRole();

    }

    public static void chooseRole() {
        Market myMarket = new Market();
        String choice;
        do {
            System.out.println("Make a choice");
            System.out.println("Log In as\n\n1-Client\n2-Administrator\n3" +
                    "-Create an Account" +
                    "\n4-Exit");
            choice = userInput.next();
        } while (!choice.equalsIgnoreCase("1") & !choice.equalsIgnoreCase("2") & !choice.equalsIgnoreCase("3") & !choice.equalsIgnoreCase("4"));
        // test du choice
        switch (choice) {
            case "1":
                Auth.isClientRegistered(myMarket);
                break;
            case "2":
                Auth.isAdminRegistered();
                break;
            case "3":
                Auth.createAccount();
                break;
            case "4":
                System.exit(0);
                break;
        }
    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    // -------------------------------------------------
    // setters
    // -------------------------------------------------

}
