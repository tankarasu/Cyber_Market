package com.company.user;

import com.company.store.Product;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Client extends User {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    private static final Scanner userInput = new Scanner(System.in);
    private static Cart myCart;


    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public Client(String p_sName, String p_sPassword) {
        myCart = new Cart(); // à voir
        setName(p_sName);
        setPassword(p_sPassword);
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
        int quantityToAdd = Integer.parseInt(choice);
        myCart.addProductToCart(p_product, quantityToAdd);

    }

    public static void buyCartContent() {
        System.out.println("products bought");
    }

    public static void clientStoreChoice() {

    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    public Cart getMyCart() {
        return myCart;
    }


    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
