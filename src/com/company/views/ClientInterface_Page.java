package com.company.views;

import com.company.store.Market;
import com.company.store.ProductList_Page;
import com.company.user.Cart_Page;
import com.company.user.User;

import javax.swing.*;
import java.awt.*;

public class ClientInterface_Page extends JFrame {

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public ClientInterface_Page() throws HeadlessException {

    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------
    public static void ShowGUI(User client, Market myMarket) {
        JFrame frame = new JFrame("Client Interface");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(760, 640);
        frame.setLocationRelativeTo(null);

        addComponentsToFrame(frame,client, myMarket);

        frame.setVisible(true);

    }

    private static void addComponentsToFrame(Container panel,
                                             User client, Market myMarket) {
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        //Title Label
        JLabel titleLabel = new JLabel("Welcome, Please make a choice");
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;

        panel.add(titleLabel, gbc);

        //Product List
        JButton productListButton = new JButton("Product List");

        gbc.gridy = 1;

        panel.add(productListButton, gbc);

        //My Cart
        JButton myCartButton = new JButton("My Cart ");

        gbc.gridy = 2;

        panel.add(myCartButton, gbc);

        //Log Out Button
        JButton logOutButton = new JButton("Log Out");

        gbc.gridy = 3;

        panel.add(logOutButton, gbc);

        logOutButton.addActionListener(e -> {
            panel.setVisible(false);
            LandingPage.ShowGUI();
        });

        productListButton.addActionListener(e -> {
            panel.setVisible(false);
            ProductList_Page.ShowGUI(client, myMarket);
        });

        myCartButton.addActionListener(e -> {
            panel.setVisible(false);
            Cart_Page.ShowGUI(client, myMarket);
        });

    }

}
