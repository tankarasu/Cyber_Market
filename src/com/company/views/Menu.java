package com.company.views;

import com.company.store.Market;
import com.company.user.Admin;
import com.company.user.Client;
import com.company.user.ClientDatabase;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    static Scanner userInput = new Scanner(System.in);
    static ClientDatabase clientDatabase = new ClientDatabase();
    static Market myMarket = new Market();

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    /**
     * Landing page of the application
     * User can be connect like Client or Administrator
     */
    public static void startApp() {
        String welcomeMessage =
                "-------------------------\n" +
                        "Bienvenue au Cyber Market\n" +
                        "-------------------------";
        System.out.println(welcomeMessage);
        chooseRole();
    }

    /**
     * with this method you choose the role you play with your logIn/password
     * pair, u can create an account if u don't have one.
     */
    public static void chooseRole() {
        StringBuilder loggingOption = new StringBuilder("");

        loggingOption
                .append("Make a choice\n")
                .append("Log In as\n\n")
                .append("1 - Client\n")
                .append("2 - Administrator\n")
                .append("3 - Create an Account\n")
                .append("4 - Exit");

        String choice;
        do {
            System.out.println(loggingOption);
            choice = userInput.next();
        } while (!Pattern.matches("^[ ]?[1234][ ]?$", choice));

        // admin toujours présent et toujours unique
        Admin admin = new Admin();

        switch (choice) {
            case "1":
                int clientIndex =
                        Auth.isClientRegistered(clientDatabase);
                if (clientIndex != -1) {
                    Client currentClient = clientDatabase.getClientList().get(clientIndex);
                    System.out.println("index client: " + clientIndex);
                    ClientInterface.ChoiceMenu(myMarket,currentClient);
                } else {
                    System.out.println("You are not registered\n try again");
                    chooseRole();
                    // todo première verif sur la récursivité ok
                }
                break;
            case "2":
                Auth.isAdminRegistered(myMarket);
                // verification de l'admin & passWord
                // error Handling
                // passWord incorrect
                // passWord vide
                // name n'existe pas
                // accès au menu AdminInterface
                // si Non Admin -> Paire Nom/Password pas bon en message
                break;
            case "3":
                // création d'un nouvel Client
                // error Handling
                // si le client existe deja
                // si le nom contient des chiffres
                // si le passWord est vide
                // si il est trop court
                // si le password = nom
                // todo option demande mail
                // ajout de l'user à la ClientDatabase
                // retour au présent menu
                Auth.createAccount();
                break;
            case "4":
                System.out.println("Au revoir et à bientôt cher Utilisateur");
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
