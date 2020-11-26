package com.company.views;

import com.company.store.Market;
import com.company.store.Product;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AdminProductList_Page extends JFrame {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public AdminProductList_Page() {
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------
    public static void ShowGUI(Market myMarket) {
        JFrame frame = new JFrame("Product in stock");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(760, 640);
        frame.setLocationRelativeTo(null);

        addComponentsToFrame(frame,myMarket);

        frame.setVisible(true);
    }

    public static void addComponentsToFrame(Container panel,Market myMarket) {
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        // title label
        JLabel titleLabel = new JLabel("Product list :");
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;

        panel.add(titleLabel, gbc);

        // todo meilleurs ventes et ruptures de Stock todo

        //Log Out Button
        JButton returnButton = new JButton("Return");

        gbc.gridy = 2;

        panel.add(returnButton, gbc);

        //Creating product Buttons
        int index = 2;
        for (Product product : myMarket.getTheStore()) {
            index++;
            JButton productButton = new JButton(product.getName());
            gbc.gridx = 0;
            gbc.gridy = index;
            panel.add(productButton, gbc);

            productButton.addActionListener(e -> {
                int productIndex = myMarket.getTheStore().indexOf(product);
                Product infoProduct = myMarket.getTheStore().get(productIndex);
                String message = "name: " + infoProduct.getName() + " - "
                        + infoProduct.getQuantity() + " pieces"
                        + infoProduct.getPrice() + " €/unit";
                JOptionPane.showMessageDialog(null, message, "détails du produit"
                        , JOptionPane.PLAIN_MESSAGE);
            });
        }

        returnButton.addActionListener(e -> {
            panel.setVisible(false);
            AdminInterface_Page.ShowGUI(myMarket);
        });

        // todo modal product successfully added
    }
    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
