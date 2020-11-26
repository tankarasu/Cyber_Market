package com.company.views;

import com.company.Main;
import com.company.store.Market;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

public class AddProduct_Page extends JFrame {

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public AddProduct_Page() throws HeadlessException {

    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------
    public static void ShowGUI(Market myMarket) {
        JFrame frame = new JFrame("Add Product Page");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(760, 640);
        frame.setLocationRelativeTo(null);

        addComponentsToFrame(frame, myMarket);

        frame.setVisible(true);
    }

    public static void addComponentsToFrame(Container panel, Market myMarket) {
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        // title label
        JLabel titleLabel = new JLabel("Add a product");
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;

        panel.add(titleLabel, gbc);

        // label name
        JLabel nameLabel = new JLabel("Name:");
        gbc.gridy = 1;

        panel.add(nameLabel, gbc);

        // textField name
        JTextField nameField = new JTextField(15);
        gbc.gridy = 2;

        panel.add(nameField, gbc);

        // quantity
        JLabel quantityLabel = new JLabel("Quantity:");
        gbc.gridy = 3;

        panel.add(quantityLabel, gbc);

        // textField quantity
        JTextField quantityField = new JTextField(15);
        gbc.gridy = 4;

        panel.add(quantityField, gbc);

        // Price
        JLabel priceLabel = new JLabel("Price:");
        gbc.gridy = 5;

        panel.add(priceLabel, gbc);

        // textField price
        JTextField priceField = new JTextField(15);
        gbc.gridy = 6;

        panel.add(priceField, gbc);

        // confirm
        JButton submitButton = new JButton("Add");
        gbc.gridy = 7;

        panel.add(submitButton, gbc);

        // return
        JButton cancelButton = new JButton("Return");
        gbc.gridy = 8;

        panel.add(cancelButton, gbc);

        // info field
        JTextPane textPane = new JTextPane();
        textPane.setText("");
        gbc.gridy = 9;

        panel.add(textPane);

        submitButton.addActionListener(e -> {
            String regexNumber = "[ ]?[0-9]+[ ]?$";
            String name = nameField.getText();
            String quantity = quantityField.getText();
            String price = priceField.getText();
            if (name.equals("") | quantity.equals("") | price.equals("") | quantity.equals("0") | price.equals("0") | !quantity.matches(regexNumber) | !price.matches(regexNumber)) {
                textPane.setText(" You must provide all fields with valid " +
                        "value");
                return;
            }else{
                myMarket.addProduct(name,Double.parseDouble(quantity),Integer.parseInt(price));
                Main.serialize(myMarket);
            }
            nameField.setText("");
            quantityField.setText("");
            priceField.setText("");

        });

        cancelButton.addActionListener(e -> {
            panel.setVisible(false);
            AdminInterface_Page.ShowGUI(myMarket);
        });
    }

}
