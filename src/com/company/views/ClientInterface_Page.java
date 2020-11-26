package com.company.views;

import javax.swing.*;
import java.awt.*;

public class ClientInterface_Page extends JFrame {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public ClientInterface_Page() throws HeadlessException {

    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------
    public static void ShowGUI() {
        JFrame frame = new JFrame("Client Interface");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(760, 640);
        frame.setLocationRelativeTo(null);

        addComponentsToFrame(frame);

        frame.setVisible(true);

    }

    private static void addComponentsToFrame(Container panel){
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        //Title Label
        JLabel titleLabel = new JLabel("Welcome"+/*clientname*/" Please make a choice");
        gbc.weightx=0.5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;

        panel.add(titleLabel, gbc);

        //Product List
        JButton productListButton = new JButton("Product List");

        gbc.gridy = 1;

        panel.add(productListButton,gbc);

        //My Cart
        JButton myCartButton = new JButton("My Cart ");

        gbc.gridy = 2;

        panel.add(myCartButton, gbc);

        //Log Out Button
        JButton logOutButton = new JButton("Log Out");

        gbc.gridy = 3;

        panel.add(logOutButton, gbc);

    }
    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
