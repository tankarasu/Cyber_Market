package com.company.views;

import com.company.user.Client;
import com.company.user.ClientDatabase;
import com.company.user.User;
import com.company.user.UserDatabase;

public class Auth {

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------


    public Auth() {
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    public static int isUserRegistered(
            UserDatabase userDatabase, String name, String password) {

        int index = 0;

        // checking the name
        boolean dbName = false;
        for (User user : userDatabase.getM_aUserList()) {
            if (user.getName().equals(name)) {
                dbName = true;
                break;
            }
        }
        // does the name in the DB exist
        if (!dbName) return -1;

        // checking the password

        boolean isRegistered = false;
        for (User user : userDatabase.getM_aUserList()) {
            if ((user.getPassword().equals(password))
                    & (user.getName().equals(name))) {
                index = userDatabase.getM_aUserList().indexOf(user);
                isRegistered = true;
                break;
            }
        }

        // user validation
        if (isRegistered) return index;

        return -1;
    }

    public static void createAccount(ClientDatabase clientDatabase,
                                     String name,
                                     String password) {

        Client newClient = new Client(name, password);
        clientDatabase.getM_aUserList().add(newClient);
    }

}
