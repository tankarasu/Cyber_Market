package com.company.user;

import com.company.store.Product;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Client {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    static Scanner userInput = new Scanner(System.in);

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public Client() {

    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    public static void selectProduct(Product p_product) {
        String regex = "^[ ]?[0-9]+[ ]?$";
        String choice;
        System.out.println(
                "nom: " + p_product.getName() + " quantity: " + p_product.getQuantity() + " price: " + p_product.getPrice()
        );
        do {
            System.out.println("How many product to add to cart ?");
            choice = userInput.next();
        } while (!Pattern.matches(regex, choice));
    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
