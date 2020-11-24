package com.company.views;

import com.company.store.Market;
import com.company.store.Product;
import com.company.user.Client;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ClientInterface {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    static Scanner userInput = new Scanner(System.in);
    //    static Client client = new Client(); todo delete si nécessaire

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public ClientInterface() {

    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------
    // todo Rajouter case 0 return depuis productlist
    public static void ChoiceMenu(Market myMarket, Client client) {
        System.out.println("Welcome " + client.getName() + "\n");
        Product baguette = new Product("baguette", 42, 2);
        String choice;
        // first window of client Interface
        do {
            StringBuilder clientInterfaceMenu = new StringBuilder("");
            clientInterfaceMenu.append("1-List products\n")
                    .append("2-My Cart\n")
                    .append("3-Log Out");
            System.out.println(clientInterfaceMenu);
            choice = userInput.next();
        } while (!Pattern.matches("^[ ]?[123][ ]?$", choice));

        switch (choice) {
            case "1":
                myMarket.getStore();
                Client.clientStoreChoice(myMarket,client);
                ChoiceMenu(myMarket,client);
                // verifier si présence du produit dans Panier todo remanier
                //  boucle
                break;
            case "2":
                // todo case cart empty
                client.getMyCart().getCart();
                ChoiceMenu(myMarket,client);
                break;
            case "3":
                Menu.chooseRole();
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
