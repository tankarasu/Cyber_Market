package com.company.views;

import com.company.store.Market;
import com.company.user.Client;
import com.company.user.ClientDatabase;
import com.company.user.User;
import com.company.user.UserDatabase;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Auth {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    static Scanner userInput = new Scanner(System.in);
    // -------------------------------------------------
    //constructor
    // -------------------------------------------------


    public Auth() {
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------
    public static void isAdminRegistered(Market myMarket) {
        System.out.println("Your are registered");
        AdminInterface.ChoiceMenu(myMarket);
    }

    public static int isUserRegistered(
            UserDatabase userDatabase) {
        String name = "";
        String password = "";
        int index = 0;

        // todo verifier les scanner avec nextLine
        // checking the name
        System.out.println("What's your name Sir?");
        name = userInput.next();

        boolean dbName = false; // false nom non présent dans la db
//        for (int i = 0; i < userDatabase.getM_aUserList().size(); i++) {
        for (User user : userDatabase.getM_aUserList()) {
            if (user.getName().equals(name)) {
                dbName = true;
                break;
            }
        }
        // is the name in the DB exist
        if (!dbName) {
            System.out.println("This userName doesn't exist!");
            return -1;
        }
        // checking th password
        System.out.println("Please enter your Password");
        password = userInput.next();

        boolean isRegistred = false;
        for (User user : userDatabase.getM_aUserList()) {
            if ((user.getPassword().equals(password))
                    & (user.getName().equals(name))) {
                index = userDatabase.getM_aUserList().indexOf(user);
                isRegistred = true;
                break;
            }
        }

        // user validation
        if (isRegistred) {
            System.out.println("\nLogged IN\n");
            return index;
            // continuer d'ici pour l'interfaceClient
        } else {
            System.out.println("Your Password is incorrect");
        }
        return -1;
    }

    public static void createAccount(ClientDatabase clientDatabase) {
        String name;
        String password;
        String regexPassword =
                "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[A-Za-z])(?=.*[a-zA-Z]).{6,}";
        String regexName = "^[a-zA-Z\\s'\\-\\pL]+$"; // todo check ?

        System.out.println("Création de compte utilisateur");

        do {
            System.out.println("Veuillez entrez votre nom:");
            name = userInput.nextLine();
        } while (!Pattern.matches(regexName, name));

        do {
            System.out.println("Veuillez entrez un mot de passe");
            password = userInput.nextLine();
        } while (!Pattern.matches(regexPassword, password));

        // todo confirmez mot de passe
        // todo donnez une description du mot de passe attendu
        Client newClient = new Client(name, password);
        clientDatabase.getM_aUserList().add(newClient);
    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
