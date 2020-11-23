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

    // todo instancied  user like admin or Client

    /**
     * with this method you choose the role you play with your logIn/password
     * pair, u can create an account if u don't have one.
     */
    public static void chooseRole() {
        Market myMarket = new Market();
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
                Client currentClient = new Client("","");
                Auth.isClientRegistered(myMarket,clientDatabase);

                // création d'une instance de Client
                // vérification au niveau de la ClientDatabase
                // new Client = new Client(nom de la database, password de la
                // db, historique db)
                // error Handling
                // nom existe
                // password corresponde au nom
                // password ne soit pas vide
                // accès au menu clientInterface
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
