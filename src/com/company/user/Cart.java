package com.company.user;

import com.company.store.Market;
import com.company.store.Order;
import com.company.store.OrderList;
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
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    public void getCart(Market myMarket, User client) {
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
                .append("3 - Return");

        do {
            System.out.println(cartMenu);
            choice = userInput.next();
        } while (!Pattern.matches("^[ ]?[123][ ]?$", choice));

        // choix de l'action sur le cart du client
        switch (choice) {
            case "1":
                // todo sales history
                Order order = new Order(client.getName(), m_aCart);

                //todo fix Orderlist later


                //myMarket.orderList.displayOrders();
                m_aCart.clear();
                System.out.println("Your cart has been processed, you will " +
                        "receive your articles soon");
                break;
            case "2":
                // on rajoute les produits de la cart au stock
                for (int i = 0; i < myMarket.getTheStore().size(); i++) {
                    for (int j = 0; j < m_aCart.size(); j++) {
                        if (myMarket.getTheStore().get(i).getName().equals(m_aCart.get(j).getName())) {
                            myMarket.getTheStore().get(i).setQuantity(myMarket.getTheStore().get(i).getQuantity() + m_aCart.get(j).getQuantity());
                        }
                    }
                }
                m_aCart.clear();
                break;

            case "3":
                return;
        }

    }

    public void addProductToCart(Product p_pProduct, int p_iProductQuantity) {
        Product cartProduct = new Product(p_pProduct.getName(),
                p_iProductQuantity, p_pProduct.getPrice());
        m_aCart.add(cartProduct);
    }

}
