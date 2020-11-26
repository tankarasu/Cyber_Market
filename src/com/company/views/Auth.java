package com.company.views;

import com.company.Main;
import com.company.store.Market;
import com.company.user.Client;
import com.company.user.ClientDatabase;
import com.company.user.User;
import com.company.user.UserDatabase;

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

    public static int isUserRegistered(
            UserDatabase userDatabase,String name,String password) {

        int index = 0;

        // checking the name
        boolean dbName = false; // false nom non présent dans la db
        for (User user : userDatabase.getM_aUserList()) {
            if (user.getName().equals(name)) {
                dbName = true;
                break;
            }
        }
        // does the name in the DB exist
        if (!dbName) {
            System.out.println("This userName doesn't exist!");// todo faire
            // une modal
            return -1;
        }
        // checking the password

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
            System.out.println("\nLogged IN\n");// todo l'afficher dans la
            // target window
            return index;
        } else {
            System.out.println("Your Password is incorrect"); //todo afficher
            // en modal
        }
        return -1;
    }

    public static void createAccount(ClientDatabase clientDatabase, UserDatabase userDatabase,
                                     String name, String password, Market myMarket) {

        Client newClient = new Client(name, password, myMarket);
        Main.serialize(newClient);
        clientDatabase.getM_aUserList().add(newClient);
        Main.serialize(userDatabase);
        Main.serialize(clientDatabase);
    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    // -------------------------------------------------
    // setters
    // -------------------------------------------------

// todo nettoyage en fin de tous les commentaires
}
