package com.company.user;

import com.company.store.Market;
import com.company.store.Product;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Client extends User {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    private static final Scanner userInput = new Scanner(System.in);
    private Cart myCart;


    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public Client(String p_sName, String p_sPassword) {
        myCart=new Cart(); // à voir todo
        setName(p_sName);
        setPassword(p_sPassword);
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

//    public static void selectProduct(Product p_product) {
//        String regex = "^[ ]?[0-9]+[ ]?$";
//        String choice;
//        System.out.println(
//                "nom: " + p_product.getName() + " quantity: " + p_product.getQuantity() + " price: " + p_product.getPrice()
//        );
//        do {
//            System.out.println("How many product to add to cart ?");
//            choice = userInput.next();
//        } while (!Pattern.matches(regex, choice));
//        int quantityToAdd = Integer.parseInt(choice);
//        myCart.addProductToCart(p_product, quantityToAdd);
//
//    }

    public static void buyCartContent() {
        System.out.println("products bought");
    }

    // displaying selected product informations
    public static void clientStoreChoice(Market myMarket, Client client) {
        String numberRegex = "^[ ]?[0-9]\\d*[ ]?$";
        String choice;
        Product currentProduct;
        int quantityToAdd = 0;
        int index = 0;
        do {
            System.out.println("Choose a product or Return");
            choice = userInput.next();
        } while (!Pattern.matches(numberRegex, choice));

        if (choice.equals("0")) return;

        // displaying information of the product
        myMarket.getSpecificProduct(Integer.parseInt(choice) - 1);
        index = Integer.parseInt((choice)) - 1;
        currentProduct =
                myMarket.getTheStore().get(Integer.parseInt(choice) - 1);

        // si valeur entrée non valide reboucle
        do {
            System.out.println("How many product to add to your cart?");
            choice = userInput.next();
        } while (!Pattern.matches(numberRegex, choice));

        // si valeur entrée = 0 -> return au menu précédent
        if (choice.equals("0")) {
            return;
        }

        // si valeur entrée > quantité disponible on met la quantité max
        // avec message d'avertissement
        if (Integer.parseInt(choice) > currentProduct.getQuantity()) {
            System.out.println("La quantité demandé dépasse le stock " +
                    "disponible, " + currentProduct.getQuantity() + "seront " +
                    "ajoutés au panier");
            quantityToAdd = currentProduct.getQuantity();

            // todo Translate
        }
        // si valeur entrée comprise entre 1 et Quantité disponible incluse
        // on ajuste la quantité à ajouter
        if ((Integer.parseInt(choice) >= 1) & (Integer.parseInt(choice) <= currentProduct.getQuantity())) {
            System.out.println("la quantité demandée sera ajoutée au panier");
            quantityToAdd = Integer.parseInt(choice);
        }

        // on ajoute la Q au cart
        client.myCart.addProductToCart(currentProduct, quantityToAdd);
        // je veux voir (to delete) ce que contient le Cart
        client.myCart.getCart();
        // on déduit la quantité du stock
        Product storeProduct = myMarket.getTheStore().get(index);
        storeProduct.setQuantity(storeProduct.getQuantity() - quantityToAdd);

        System.out.println("Quantité restant en stock: " + storeProduct.getQuantity() + " pièces");
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
