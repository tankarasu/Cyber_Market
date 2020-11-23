package com.company.views;

import com.company.store.Market;
import com.company.store.Product;
import com.company.user.Client;

import java.util.Scanner;

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
    public static void ChoiceMenu(Market myMarket) {
        Product baguette = new Product("baguette", 42, 2);
        String choice;
        do {
            System.out.println("What do you want to do ?");
            System.out.println("1-List products\n2-My Cart\n3-Log Out");
            choice = userInput.next();
        } while (!choice.equalsIgnoreCase("1") & !choice.equalsIgnoreCase("2") & !choice.equalsIgnoreCase("3"));
        switch (choice) {
            case "1":
                myMarket.getStore();
                // todo choisir l'article voulu
                Client.clientStoreChoice();// à améliorer
                //Client.selectProduct(baguette);
                break;
            case "2":
               // client.getMyCart().getCart();
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
