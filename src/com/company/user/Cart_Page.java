package com.company.user;

import com.company.Main;
import com.company.store.Market;
import com.company.store.Product;
import com.company.views.ClientInterface_Page;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Cart_Page extends JFrame {

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public Cart_Page() {
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    public static void ShowGUI(User client, Market myMarket) {
        JFrame frame = new JFrame("My Cart");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(760, 640);
        frame.setLocationRelativeTo(null);

        addComponentsToFrame(frame, client, myMarket);

        frame.setVisible(true);
    }

    public static void addComponentsToFrame(Container panel,
                                            User client, Market myMarket) {
        //ArrayList<Product> clientCart = client.getMyCart().m_aCart;
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        // Label title
        JLabel titleLabel = new JLabel("The Cart");
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 1;

        panel.add(titleLabel, gbc);

        // Buy all product button
        JButton buyAllButton = new JButton("Buy all Products    ");
        gbc.gridy = 3;

        panel.add(buyAllButton, gbc);

        // Remove all product button
        JButton removeAllButton = new JButton("Remove all Products");
        gbc.gridy = 4;

        panel.add(removeAllButton, gbc);

        // Display Cart
        JTextArea resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        gbc.ipadx = 150;
        gbc.gridwidth = 500;
        JScrollPane resultScrollPane = new JScrollPane(resultTextArea);
        gbc.gridwidth = 500;

        gbc.ipadx = 150;
        gbc.gridy = 5;

        layout.setConstraints(resultScrollPane, gbc);
        panel.add(resultScrollPane);
        gbc.ipady=0;
        //JTextPane textPane = new JTextPane();
        //String textPaneText = "Your Cart is Empty";

        int total=0;
        for (Product product : client.getMyCart().m_aCart) {
            total+=(product.getQuantity() * product.getPrice());
            int index = client.getMyCart().m_aCart.indexOf(product);
            resultTextArea.append((index + 1) + " - " + product.getName()
                    + " Quantity:" + product.getQuantity()
                    + " price: " + product.getPrice() + " €/unit\n");
        }resultTextArea.append("Total bill value: "+total+"€");

        //textPane.setText(textPaneText);
        //textPane.setEnabled(false);
        //gbc.gridy = 4;


        //panel.add(textPane, gbc);


        // Return button
        JButton returnButton = new JButton("Return");
        gbc.gridy = 6;
        gbc.weightx = 0.5;
        panel.add(returnButton, gbc);

        // Event listeners
        // buy ALl products
        buyAllButton.addActionListener(e -> {
            client.getMyCart().m_aCart.clear();
                    Main.serialize(myMarket);
                    resultTextArea.setText("Your cart has been processed, you will " +
                            "receive your articles soon");
            }
        );

        // remove product
        removeAllButton.addActionListener(e -> {
            client.getMyCart().m_aCart.clear();
                    resultTextArea.setText("Your cart has been reseted and the " +
                            "products go back to the store");

            }
        );

        // return
        returnButton.addActionListener(e -> {
            panel.setVisible(false);
            ClientInterface_Page.ShowGUI(client, myMarket);
        });
    }

}
