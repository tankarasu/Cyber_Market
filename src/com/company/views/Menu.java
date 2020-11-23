package com.company.views;

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
        String choice;
        do {
            System.out.println("Make a choice");
            System.out.println("Log In as\n\n1-Client\n2-Administrator\n3-Exit");
            choice = userInput.next();
        } while (!choice.equalsIgnoreCase("1") & !choice.equalsIgnoreCase("2") & !choice.equalsIgnoreCase("3"));
        // test du choice
        System.out.println(choice); // todo to delete when ok
    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    // -------------------------------------------------
    // setters
    // -------------------------------------------------

}
