package com.company.user;

import com.company.store.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    public ArrayList<Product> m_aCart;
    public Scanner userInput;

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

    public void getCart() {
//        double m_dTotalPrice=0;
//        m_dTotalPrice+=product.getPrice();
        System.out.println("Panier");
        for (Product product : m_aCart) {
            int index = m_aCart.indexOf(product);
            System.out.println((index + 1) + " - " + product.getName() + " " +
                    "Quantity:" + product.getQuantity() + " price:" + product.getPrice());
        }
//        System.out.println("Total price: "+m_dTotalPrice+"\nWhat do you want to do?\n1 - Buy cart\n2 - Remove all products\n3 - Return");
//        userInput = new Scanner(System.in);
//        String choice = userInput.next();
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
//                case "3":
//                    return;
        //   }
//        }while (!choice.equalsIgnoreCase("1") & !choice.equalsIgnoreCase("2"));

//    public ArrayList<Product> getCart() {
//        return m_aCart;
    }

    public void addProductToCart(Product p_pProduct, int p_iProductQuantity) {
        Product cartProduct = new Product(p_pProduct.getName(),
                p_iProductQuantity, p_pProduct.getPrice());
//        p_pProduct.setQuantity(p);*/
        m_aCart.add(cartProduct);
    }

    public void removeProductFromCart(Product p_pProduct, int p_iProductQuantity) {
        m_aCart.remove(p_pProduct);
    } // todo a vérifier: quantité de produits, ne pas tout supprimer d'un coup

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
