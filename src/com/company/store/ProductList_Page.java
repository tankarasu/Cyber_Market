package com.company.store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProductList_Page extends JFrame {

    public ProductList_Page() {

    }

    public static void ShowGUI() {
        JFrame frame = new JFrame("Product list");
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

        //Log Out Button
        JButton returnButton = new JButton("Return");

        gbc.gridy = 1;

        panel.add(returnButton, gbc);

        //Creating product Buttons
        Market productListMarket = new Market();
        ArrayList<Product> store = productListMarket.getTheStore();
        int index = 1;
        for(Product product:store){
            index++;
            JButton productButton = new JButton(product.getName());
            gbc.gridx=0;
            gbc.gridy=index;
            panel.add(productButton,gbc);
        }
    }
}
