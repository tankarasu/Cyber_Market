package com.company.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminInterface_Page extends JFrame {

    //Title (label)
    //buttons : product list
    //add product
    //order history
    //return


    public AdminInterface_Page() throws HeadlessException {

    }

    public static void ShowGUI() {
        JFrame frame = new JFrame("Admin Interface");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(760, 640);
        frame.setLocationRelativeTo(null);

        addComponentsToFrame(frame);

        frame.setVisible(true);
    }

    public static void addComponentsToFrame(Container panel){
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        //Tantle label
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

        productListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                AdminProductList_Page.ShowGUI();
            }
        });

        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                AddProduct_Page.ShowGUI();
            }
        });

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                LandingPage.ShowGUI();
            }
        });
    }
}
