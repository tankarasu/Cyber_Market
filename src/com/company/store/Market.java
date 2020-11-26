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
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    public void addProductMenu() {
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

    public void addProduct(String p_sProductName, double p_dProductPrice, int p_iQuantity) {
        m_aStore.add(new Product(p_sProductName, p_iQuantity, p_dProductPrice));
        System.out.println("Product added");
    }

    //Displays the list of products
    public void getProductList() {
        for (Product product : m_aStore) {
            int index = m_aStore.indexOf(product);
            System.out.println((index + 1) + " - " + product.getName() + " " +
                    "Quantity:" + product.getQuantity() + " price:" + product.getPrice());
        }
    }

    //Displays only one product
    public void getSpecificProduct(int index) {
        StringBuilder result = new StringBuilder("");
        result.append(m_aStore.get(index).getName() + " - ")
                .append(m_aStore.get(index).getQuantity() + " pieces in " +
                        "Stock - ")
                .append(m_aStore.get(index).getPrice() + " €/unit");
        System.out.println(result);
    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    //Regular getter to get the ArrayList
    public ArrayList<Product> getTheStore() {
        return m_aStore;
    }


}
