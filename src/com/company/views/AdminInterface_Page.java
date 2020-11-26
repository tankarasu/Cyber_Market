package com.company.views;

import com.company.store.Market;

import javax.swing.*;
import java.awt.*;

public class AdminInterface_Page extends JFrame {

    public AdminInterface_Page() throws HeadlessException {

    }

    public static void ShowGUI(Market myMarket) {
        JFrame frame = new JFrame("Admin Interface");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(760, 640);
        frame.setLocationRelativeTo(null);

        addComponentsToFrame(frame, myMarket);

        frame.setVisible(true);
    }

    public static void addComponentsToFrame(Container panel, Market myMarket){
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        //Title label
        JLabel titleLabel = new JLabel("Please select menu");
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;

        panel.add(titleLabel, gbc);

        //product list button
        JButton productListButton = new JButton("Product list");

        gbc.gridy = 1;

        panel.add(productListButton,gbc);

        //Add product
        JButton addProductButton = new JButton("Add product");

        gbc.gridy = 2;

        panel.add(addProductButton,gbc);

        //Order History
        JButton orderHistoryButton = new JButton("Order history");

        gbc.gridy = 3;

        panel.add(orderHistoryButton,gbc);

        //Log Out Button
        JButton logOutButton = new JButton("Log Out");

        gbc.gridy = 4;

        panel.add(logOutButton, gbc);

        productListButton.addActionListener(e -> {
            panel.setVisible(false);
            AdminProductList_Page.ShowGUI(myMarket);
        });

        addProductButton.addActionListener(e -> {
            panel.setVisible(false);
            AddProduct_Page.ShowGUI(myMarket);
        });

        logOutButton.addActionListener(e -> {
            panel.setVisible(false);
            LandingPage.ShowGUI();
        });
    }
}
