package com.company.user;

import com.company.store.Market;
import com.company.store.Product;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Cart {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    public ArrayList<Product> m_aCart;
    public Scanner userInput = new Scanner(System.in);

    // -------------------------------------------------
    // constructor
    // -------------------------------------------------

    public Cart() {
        m_aCart = new ArrayList<>();
        // todo bien instancier les cart
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    public void getCart(Market myMarket) {
        // todo case panier vide

        System.out.println("Panier");
        double totalPrice = 0;
        String choice;
        if (!m_aCart.isEmpty()) {
            for (Product product : m_aCart) {
                int index = m_aCart.indexOf(product);
                System.out.println((index + 1) + " - " + product.getName() + " " +
                        "Quantity:" + product.getQuantity() + " price:" + product.getPrice());
                totalPrice += (product.getQuantity() * product.getPrice());
            }
        }
        StringBuilder cartMenu = new StringBuilder("");
        cartMenu
                .append("Total price of your cart: " + totalPrice + "€\n")
                .append("--------------------------\n")
                .append("1 - Buy cart\n")
                .append("2 - Remove all products\n")
//                .append("3 - Remove Specific product\n")
                .append("3 - Return");

        // buy all product in Cart
        // vide la cart
        // au revoir vers la page de log

        // remove a specific Product

        // remove All product

        do {
            System.out.println(cartMenu);
            choice = userInput.next();
        } while (!Pattern.matches("^[ ]?[123][ ]?$", choice));

        // choix de l'action sur le cart du client
        switch (choice) {
            case "1":
                // todo sales history
                m_aCart.clear();
                System.out.println("Your cart has been processed, you will " +
                        "receive your articles soon");
                break;
            case "2":
                // on rajoute les produits de la cart au stock
                for (int i = 0; i < myMarket.getTheStore().size(); i++) {
                    for (int j = 0; j < m_aCart.size(); j++) {
                        // mother fucking condition
                        if (myMarket.getTheStore().get(i).getName().equals(m_aCart.get(j).getName())) {
                            myMarket.getTheStore().get(i).setQuantity(myMarket.getTheStore().get(i).getQuantity() + m_aCart.get(j).getQuantity());
                        }
                    }
                }
                m_aCart.clear();
                break;
//            case "3": // todo nice to have
//                break;
            case "3":
                return;
        }

//        do{
//            switch (choice) {
//                case "1":
//                    System.out.println("Buy menu");
//                    //Appel achat cart
//                    Client.buyCartContent();
//                    System.out.println("you have bought the contents of the cart");
//                    Menu.startApp();
//                    return;
//                case "2":
//                    removeAllProducts();
//                    Menu.startApp();
//                    return;
//
        //   }

//    public ArrayList<Product> getCart() {
//        return m_aCart;
    }

    public void addProductToCart(Product p_pProduct, int p_iProductQuantity) {
        Product cartProduct = new Product(p_pProduct.getName(),
                p_iProductQuantity, p_pProduct.getPrice());
//        p_pProduct.setQuantity(p);*/
        m_aCart.add(cartProduct);
    }

//    public void removeProductFromCart(Product p_pProduct, int p_iProductQuantity) {
//        m_aCart.remove(p_pProduct);
//    } // todo a vérifier: quantité de produits, ne pas tout supprimer d'un coup

    public void removeAllProducts() {
//        m_aCart.clear();
        System.out.println("Your cart is now empty");
    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
