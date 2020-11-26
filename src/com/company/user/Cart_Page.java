package com.company.user;

import com.company.store.Product;
import com.company.views.ClientInterface_Page;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Cart_Page extends JFrame {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public Cart_Page() {
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    public static void ShowGUI(User client) {
        JFrame frame = new JFrame("My Cart");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(760, 640);
        frame.setLocationRelativeTo(null);

        addComponentsToFrame(frame, client);

        frame.setVisible(true);
    }

    public static void addComponentsToFrame(Container panel,
                                            User client) {
        ArrayList<Product> clientCart = client.getMyCart().m_aCart;
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        // Label title
        JLabel titleLabel = new JLabel("The Cart");
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 1;

        panel.add(titleLabel, gbc);

        // Buy all product button
        JButton buyAllButton = new JButton("Buy all Products");
        gbc.gridy = 2;

        panel.add(buyAllButton, gbc);

        // Remove all product button
        JButton removeAllButton = new JButton("Remove all Products");
        gbc.gridy = 3;

        panel.add(removeAllButton, gbc);

        // affichage du Cart
        JTextPane textPane = new JTextPane();
        String textPaneText = "Your Cart is Empty";

        for (Product product : clientCart) {
            textPaneText = "";
            int index = clientCart.indexOf(product);
            textPaneText += (index + 1) + " - " + product.getName()
                    + " Quantity:" + product.getQuantity()
                    + " price: " + product.getPrice() + " €/unit\n";
            textPaneText += "total: " + (product.getQuantity() * product.getPrice())
                    + " €\n";

        }
        textPane.setText(textPaneText);
        textPane.setEnabled(false);
        gbc.gridy = 4;

        panel.add(textPane, gbc);
        // todo sales history
        // todo fix Orderlist later

        // Return button
        JButton returnButton = new JButton("Return");
        gbc.gridy = 5;

        panel.add(returnButton, gbc);

        // modal confirm pay + total to pay
        // todo  JOptionPane confirmPay = new JOptionPane();
        // todo case cart empty

        // Event listeners
        // buy ALl products
        buyAllButton.addActionListener(e -> {
                    clientCart.clear();
                    textPane.setText("Your cart has been processed, you will " +
                            "receive your articles soon");
                }
        );

        removeAllButton.addActionListener(e -> {
                    clientCart.clear();
                    textPane.setText("Your cart has been reseted and the " +
                            "products go back to the store");
                }
        );

        returnButton.addActionListener(e -> {
            panel.setVisible(false);
            ClientInterface_Page.ShowGUI(client);
        });
    }
    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
