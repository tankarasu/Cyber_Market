package com.company.store;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Market {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    ArrayList<Product> m_aStore = new ArrayList<>();
    Product baguette = new Product("baguette", 42, 2.0);
    Product pain = new Product("pain", 42, 1.0);
    Scanner userInput = new Scanner(System.in);


    // -------------------------------------------------
    // constructor
    // -------------------------------------------------


    public Market() {
        m_aStore.add(baguette);
        m_aStore.add(pain);
        System.out.println(m_aStore);
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    public static void removeProduct(){
        System.out.println("Produit supprimé");
    }

    public void addProductMenu(){
        String regex = "^[ ]?[0-9]+[ ]?$";
        // todo inclure String.trim()
        String choice;

        System.out.println("Enter product name");
        String productName = userInput.next();

        do {
            System.out.println("Enter product price");
            choice = userInput.next();
        } while (!Pattern.matches(regex, choice));
        double productPrice = Double.parseDouble(choice);
        // todo plus tard, changer regex pour prise en compte de nombres à virgule

        do {
            System.out.println("Enter product quantity");
            choice = userInput.next();
        } while (!Pattern.matches(regex, choice));
        int productQuantity = Integer.parseInt(choice);

        addProduct(productName, productPrice, productQuantity);
    }

    public void addProduct(String p_sProductName, double p_dProductPrice, int p_iQuantity){
        m_aStore.add( new Product(p_sProductName, p_iQuantity, p_dProductPrice));
        System.out.println("Product added");
    }

    public String getStore() {
        for (Product product : m_aStore) {
            int index = m_aStore.indexOf(product);
            System.out.println((index + 1)+" - name:" + product.getName() + " " +
                    "Quantity:" + product.getQuantity() + " price:" + product.getPrice());
        }
        //si on ne choisit pas de produit direction
        return null;
    }

    public void listAllProduct() {
        System.out.println("Il y a 5 produits dans le store");
    }
    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
