package com.company.views;

import com.company.Main;
import com.company.store.Market;
import com.company.store.Product;

import javax.swing.*;
import java.awt.*;

public class AdminProductList_Page extends JFrame {

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
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null);

        addComponentsToFrame(frame, myMarket);

        frame.setVisible(true);
    }

    public static void addComponentsToFrame(Container panel, Market myMarket) {
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
                        + infoProduct.getPrice() + " € /unit\n"
                        + "Please specify a quantity to add/remove";
                String stringNewQuantity = (String) JOptionPane.showInputDialog(null, message, "Product details"
                        , JOptionPane.PLAIN_MESSAGE, null, null, "0");
                int newQuantity = 0;
                newQuantity = Integer.parseInt(stringNewQuantity);
                if (newQuantity < 0 && java.lang.Math.abs(newQuantity) > infoProduct.getQuantity()) {
                    infoProduct.setQuantity(0);
                } else {
                    infoProduct.setQuantity(infoProduct.getQuantity() + newQuantity);
                }

                Main.serialize(myMarket);

            });

        }

        returnButton.addActionListener(e -> {
            panel.setVisible(false);
            AdminInterface_Page.ShowGUI(myMarket);
        });

    }

}
