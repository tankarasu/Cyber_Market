package com.company.store;

import com.company.user.ClientDatabase;
import com.company.user.User;
import com.company.views.ClientInterface_Page;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProductList_Page extends JFrame {

    public ProductList_Page() {

    }

    public static void ShowGUI(User client) {
        JFrame frame = new JFrame("Product list");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(760, 640);
        frame.setLocationRelativeTo(null);

        addComponentsToFrame(frame, client);

        frame.setVisible(true);
    }

    public static void addComponentsToFrame(Container panel,
                                            User client) {
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
        for (Product product : store) {
            index++;
            // initialise quantity array to display in JOptionPane
            String[] displayQuantity = new String[product.getQuantity()];
            for (int i = 0; i < product.getQuantity(); i++) {
                displayQuantity[i] = String.valueOf(i + 1);
            }

            JButton productButton = new JButton(product.getName());
            gbc.gridx = 0;
            gbc.gridy = index;
            panel.add(productButton, gbc);

            // selection of a Product
            productButton.addActionListener(e -> {
                String productQuantity =
                        (String) JOptionPane.showInputDialog(null,
                                "How many product to add ?\n" + product.getQuantity() + " pieces available",
                                "Add to cart", JOptionPane.PLAIN_MESSAGE);

                // ajout au cart
                client.getMyCart().addProductToCart(product, Integer.parseInt(productQuantity));
                product.setQuantity(product.getQuantity() - Integer.parseInt(productQuantity));

            });
        }
        returnButton.addActionListener(e -> {
            panel.setVisible(false);
            ClientInterface_Page.ShowGUI(client);
        });
    }
}
