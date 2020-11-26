package com.company.views;

import com.company.Main;
import com.company.store.Market;
import com.company.user.*;
import java.util.regex.Pattern;

public class Menu {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    static Market myMarket;
    static ClientDatabase clientDatabase;
    static AdminDatabase adminDatabase;
    static UserDatabase userDatabase;

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

        myMarket = (Market)Main.isDeSerialized("Market");
        if(myMarket==null){
            myMarket = new Market();
        }
        userDatabase = (UserDatabase)Main.isDeSerialized("UserDatabase");
        if(userDatabase==null){
            userDatabase = new UserDatabase();
        }
        clientDatabase = (ClientDatabase)Main.isDeSerialized("ClientDatabase");
        if(clientDatabase==null){
            Client clientOne = new Client("John", "AZERTY1");
            clientDatabase = new ClientDatabase(clientOne);
        }
        userDatabase = (UserDatabase)Main.isDeSerialized("UserDatabase");
        if(userDatabase==null){
            userDatabase = new UserDatabase();
        }

        Admin admin = new Admin("Admin","Root");
        adminDatabase = new AdminDatabase(admin);

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
            choice = Main.getInput();
        } while (!Pattern.matches("^[ ]?[1234][ ]?$", choice));

        // admin toujours présent et toujours unique
        //Admin admin = new Admin();

        switch (choice) {
            case "1":
                int clientIndex =
                        Auth.isUserRegistered(clientDatabase);
                if (clientIndex != -1) {
                    ClientInterface.ChoiceMenu(myMarket, clientDatabase.getM_aUserList().get(clientIndex));
                } else {
                    System.out.println("You are not registered\n try again");
                    chooseRole();
                }
                break;
            case "2":
                int adminIndex =
                        Auth.isUserRegistered(adminDatabase);
                if (adminIndex != -1) {
                    AdminInterface.ChoiceMenu(myMarket);
                } else {
                    System.out.println("You are not registered\n try again");
                    chooseRole();
                }
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
                Auth.createAccount(clientDatabase, userDatabase);
                chooseRole();
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
