package com.company.store;

import javax.swing.*;
import java.awt.*;

public class Product_Page extends JFrame {
    Product product;

    public Product_Page(Product product) throws HeadlessException {
        this.product = product;
    }

    public static void ShowGUI(Product product) {
        JFrame frame = new JFrame(product.getName());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(760, 640);
        frame.setLocationRelativeTo(null);

        addComponentsToFrame(frame,product);

        frame.setVisible(true);
    }

    public static void addComponentsToFrame(Container panel, Product product) {
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        //jbutton add to cart
        //jbutton return


        //jlabel title produit
        JLabel productTitle = new JLabel(product.getName());
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;

        panel.add(productTitle,gbc);

        //jlabel produit unitaire concaténé
        JLabel price = new JLabel("Unit price : "+String.valueOf(product.getPrice()));

        gbc.gridy = 1;

        panel.add(price,gbc);


        //jlabel quantité
        JLabel quantity = new JLabel("Available quantity : "+String.valueOf(product.getQuantity()));

        gbc.gridy = 2;

        panel.add(quantity,gbc);

        //jtextfield entrer qté
        JTextField inputQuantity = new JTextField();

    }
}
