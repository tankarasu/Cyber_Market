package com.company.user;

import com.company.store.Market;
import com.company.store.Product;
import com.company.views.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    static ArrayList<Product> m_aCart;
    static Scanner userInput;

    // -------------------------------------------------
    // constructor
    // -------------------------------------------------

    public Cart() {
        m_aCart = new ArrayList<>();
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    public void getCart() {
        double m_dTotalPrice=0;
        for (Product product : m_aCart) {
            int index = m_aCart.indexOf(product);
            System.out.println((index + 1) + " - name:" + product.getName() + " " +
                    "Quantity:" + product.getQuantity() + " price:" + product.getPrice());
        m_dTotalPrice+=product.getPrice();
        }
        System.out.println("Total price: "+m_dTotalPrice+"\nWhat do you want to do?\n1 - Buy cart\n2 - Remove all products\n3 - Return");
        userInput = new Scanner(System.in);
        String choice = userInput.next();
        do{
            switch (choice) {
                case "1":
                    System.out.println("Buy menu");
                    //Appel achat cart
                    Client.buyCartContent();
                    System.out.println("you have bought the contents of the cart");
                    Menu.startApp();
                    return;
                case "2":
                    removeAllProducts();
                    Menu.startApp();
                    return;
                case "3":
                    return;
            }
        }while (!choice.equalsIgnoreCase("1") & !choice.equalsIgnoreCase("2"));


    }

    public ArrayList<Product> getM_aCart() {
        return m_aCart;
    }

    public void addProductToCart(Product p_pProduct, int p_iProductQuantity){

        m_aCart.add(p_pProduct);
        Market.removeProduct(); // todo remplacer avec l'instance myMarket
    }

    public void removeProductFromCart(Product p_pProduct, int p_iProductQuantity){
        m_aCart.remove(p_pProduct);
    } // todo a vérifier: quantité de produits, ne pas tout supprimer d'un coup

    private static void removeAllProducts(){
        m_aCart.clear();
        System.out.println("Your cart is now empty");
    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
