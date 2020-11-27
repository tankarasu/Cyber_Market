package com.company.store;

import com.company.user.User;
import com.company.views.ClientInterface_Page;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

public class ProductList_Page extends JFrame {


    public ProductList_Page() {

    }

    public static void ShowGUI(User client, Market myMarket) {
        JFrame frame = new JFrame("Product list");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(760, 640);
        frame.setLocationRelativeTo(null);

        addComponentsToFrame(frame, client, myMarket);

        frame.setVisible(true);
    }

    public static void addComponentsToFrame(Container panel,
                                            User client, Market myMarket) {
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

        // information text
        JTextPane textPane = new JTextPane();
        textPane.setText("Complementary info : ");
        textPane.setEnabled(false);
        gbc.weightx = 0.5;
        gbc.gridy = 1;

        panel.add(textPane, gbc);

        //Log Out Button
        JButton returnButton = new JButton("Return");

        gbc.gridy = 2;

        panel.add(returnButton, gbc);

        //Creating product Buttons

        int index = 2;
        for (Product product : myMarket.getTheStore()) {
            int productIndex = myMarket.getTheStore().indexOf(product);
            index++;

            JButton productButton = new JButton(product.getName());
            gbc.gridx = 0;
            gbc.gridy = index;
            panel.add(productButton, gbc);

            // selection of a Product
            productButton.addActionListener(e -> {
                String numberRegex = "^[ ]?[0-9]\\d*[ ]?$";
                String productQuantity="";

                productQuantity = JOptionPane.showInputDialog(null,
                        "How many product to add ?\n",
                        "Add to cart", JOptionPane.PLAIN_MESSAGE);

                // validation du formulaire Q
                // number isn't valid
                if (!Pattern.matches(numberRegex, productQuantity)) {
                    textPane.setText("Please enter a valid number");
                    return;
                }
                if (Integer.parseInt(productQuantity) <= 0) {
                    textPane.setText("Please enter a valid number");
                    return;
                }

                // number > available
                if (Integer.parseInt(productQuantity) > product.getQuantity()) {
                    textPane.setText("Quantité max: " + product.getQuantity()
                            + " pieces\n" + product.getQuantity()
                            + " will be added to the Cart");
                    productQuantity = String.valueOf(product.getQuantity());
                }

                // add to cart
                client.getMyCart().addProductToCart(product, Integer.parseInt(productQuantity));

                // remove from stock
                myMarket.getTheStore().get(productIndex).setQuantity(product.getQuantity() - Integer.parseInt(productQuantity));

            });
        }
        returnButton.addActionListener(e -> {
            panel.setVisible(false);
            ClientInterface_Page.ShowGUI(client, myMarket);
        });
    }
}
