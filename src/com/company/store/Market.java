package com.company.store;

import com.company.Main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Market implements Serializable {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    ArrayList<Product> m_aStore = new ArrayList<>();


    // -------------------------------------------------
    // constructor
    // -------------------------------------------------


    public Market() {
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    public void addProductMenu() {
        String regex = "^[ ]?[0-9]+[ ]?$";
        // todo inclure String.trim()
        String choice;

        System.out.println("Enter product name");
        String productName = Main.getInput();

        do {
            System.out.println("Enter product price");
            choice = Main.getInput();
        } while (!Pattern.matches(regex, choice));
        double productPrice = Double.parseDouble(choice);
        // todo plus tard, changer regex pour prise en compte de nombres à virgule

        do {
            System.out.println("Enter product quantity");
            choice = Main.getInput();
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
