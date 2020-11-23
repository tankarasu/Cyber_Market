package com.company.store;

import java.util.ArrayList;

public class Market {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    ArrayList<Product> m_aStore = new ArrayList<>();
    Product baguette = new Product("baguette", 42, 2.0);
    Product pain = new Product("pain", 42, 1.0);


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
    public String getStore() {
        for (Product product : m_aStore) {
            int index = m_aStore.indexOf(product);
            System.out.println((index + 1)+" - name:" + product.getName() + " " +
                    "Quantity:" + product.getQuantity() + " price:" + product.getPrice());
        }

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
