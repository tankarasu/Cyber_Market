package com.company.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProduct_Page extends JFrame {

    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public AddProduct_Page() throws HeadlessException {

    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------
    public static void ShowGUI() {
        JFrame frame = new JFrame("Landing Page");
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
        JLabel titleLabel = new JLabel("Add a product");
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 1;

        panel.add(titleLabel, gbc);

        // label nom
        JLabel nameLabel = new JLabel("Name:");
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);
        // textField nom
        JTextField nameField = new JTextField();
        gbc.gridy = 1;
        panel.add(nameField, gbc);
        // quantité
        JLabel quantityLabel = new JLabel("Quantity:");
        gbc.gridy = 2;
        panel.add(quantityLabel, gbc);
        // textField quantité
        JTextField quantityField = new JTextField();
        gbc.gridy = 3;
        panel.add(quantityField, gbc);
        // Prix
        JLabel priceLabel = new JLabel("Price:");
        gbc.gridy = 4;
        panel.add(priceLabel, gbc);
        // textField prix
        JTextField priceField = new JTextField();
        gbc.gridy = 5;
        panel.add(priceField, gbc);
        // confirm
        JButton submitButton = new JButton("Add");
        gbc.gridy = 6;
        panel.add(submitButton, gbc);
        // return
        JButton cancelButton = new JButton("Return");
        gbc.gridy = 7;
        panel.add(cancelButton, gbc);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                AdminInterface_Page.ShowGUI();
            }
        });
    }
    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
