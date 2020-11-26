package com.company.user;

import javax.swing.*;
import java.awt.*;

public class Cart_Page extends JFrame {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public Cart_Page() {
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    public static void ShowGUI() {
        JFrame frame = new JFrame("My Cart");
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

        // Label title
        JLabel titleLabel = new JLabel("The Cart");
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 1;

        panel.add(titleLabel, gbc);

        // Buy all product button
        JButton buyAllButton = new JButton("Buy all Products");
        gbc.gridy = 2;

        panel.add(buyAllButton, gbc);

        // Remove all product button
        JButton removeAllButton = new JButton("Remove all Products");
        gbc.gridy = 3;

        panel.add(removeAllButton, gbc);

        // Return button
        JButton returnButton = new JButton("Return");
        gbc.gridy=4;

        panel.add(returnButton,gbc);

        // modal confirm pay + total to pay
      // todo  JOptionPane confirmPay = new JOptionPane();


    }
    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
