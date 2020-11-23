package com.company.views;

import com.company.store.Market;
import com.company.user.Client;
import com.company.user.ClientDatabase;

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

    public static boolean isClientRegistered(
            Market myMarket,
            ClientDatabase clientDatabase) {
        String name = "";
        String password = "";
        // todo verifier les scanner avec nextLine
        do {
            System.out.println("What's your name Sir?");
            name = userInput.next();
        } while (!Pattern.matches("^[a-zA-Z\\s'\\-\\pL]+$", name));

        do {
            System.out.println("Please enter your Password");
            password = userInput.next();
        } while (!Pattern.matches("^(?=.*[0-9]+.*)(?=.*[a-zA-Z]+.*)" +
                "[0-9a-zA-Z@!:;_-]{6,}$", password));

        // validation du client et Password
        boolean isRegistred = false;
        for (Client client : clientDatabase.getClientList()) {
            if ((client.getPassword().equals(password))
                    & (client.getName().equals(name))) {
                isRegistred = true;
                break;
            }
            return isRegistred;
        }

        if (isRegistred) {
            System.out.println("Your are registred");
            // continuer d'ici pour l'interfaceClient
        } else {
            System.out.println("Your Name or Password are incorrect");
        }

        // ClientInterface.ChoiceMenu(myMarket);
        return true;
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
