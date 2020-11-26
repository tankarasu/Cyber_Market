package com.company.store;

import com.company.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Product_Page extends JFrame {
    Product product;

    public Product_Page(Product product) throws HeadlessException {
        this.product = product;
    }

    public static void ShowGUI(Product product,
                               User client, Market myMarket) {
        JFrame frame = new JFrame(product.getName());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(760, 640);
        frame.setLocationRelativeTo(null);

        addComponentsToFrame(frame, product, client, myMarket);

        frame.setVisible(true);
    }

    public static void addComponentsToFrame(Container panel,
                                            Product product,
                                            User client,
                                            Market myMarket) {
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        //jlabel product title
        JLabel productTitle = new JLabel(product.getName());
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;

        panel.add(productTitle, gbc);

        //jlabel unit price of a specific product
        JLabel price = new JLabel("Unit price : " + String.valueOf(product.getPrice()));
        gbc.gridy = 1;

        panel.add(price, gbc);


        //jlabel quantity
        JLabel quantity = new JLabel("Available quantity : " + String.valueOf(product.getQuantity()));
        gbc.gridy = 2;

        panel.add(quantity, gbc);

        //jtextfield to enter quantity
        JTextField inputQuantity = new JTextField();
        gbc.gridy = 3;

        panel.add(inputQuantity);

        //add to Cart button
        JButton addToCart = new JButton("Add to Cart");
        gbc.gridy = 4;

        panel.add(addToCart, gbc);

        // button return
        JButton returnButton = new JButton("Return");
        gbc.gridy = 5;

        panel.add(returnButton, gbc);
        // todo Joption pane for logout confirmation

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                ProductList_Page.ShowGUI(client, myMarket);
            }
        });


    }
}
