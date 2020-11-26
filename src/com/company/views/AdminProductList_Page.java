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
    public static void ShowGUI() {
        JFrame frame = new JFrame("Product in stock");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(760, 640);
        frame.setLocationRelativeTo(null);

        addComponentsToFrame(frame);

        frame.setVisible(true);
    }

    public static void addComponentsToFrame(Container panel) {
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
        Market productListMarket = new Market();
        ArrayList<Product> store = productListMarket.getTheStore();
        int index = 2;
        for (Product product : store) {
            index++;
            JButton productButton = new JButton(product.getName());
            gbc.gridx = 0;
            gbc.gridy = index;
            panel.add(productButton, gbc);

            productButton.addActionListener(e -> {
                JOptionPane()
            });
        }

        returnButton.addActionListener(e -> {
            panel.setVisible(false);
            AdminInterface_Page.ShowGUI();
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
