package com.company.views;

import com.company.Main;
import com.company.store.Market;
import com.company.store.Product;
import javax.swing.*;
import java.awt.*;

public class LandingPage extends JFrame {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    public static String role = "";
    public static Market myMarket;

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public LandingPage() throws HeadlessException {

    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------


    public static void ShowGUI() {
        myMarket = (Market) Main.isDeSerialized("Market");
        if(myMarket==null){
            myMarket = new Market();
            Product baguette = new Product("Baguette", 42, 2.0);
            Product pain = new Product("Pain", 42, 1.0);
            myMarket.getTheStore().add(baguette);
            myMarket.getTheStore().add(pain);
        }

        JFrame frame = new JFrame("Landing Page");
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
        JLabel titleLabel = new JLabel("Welcome to the Cyber Market dear User");
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 1;

        panel.add(titleLabel, gbc);

        // Log Client
        // spacing after the text in button adjust the size of the button
        JButton clientLogButton = new JButton("Log in as Client     ");
        gbc.gridy = 2;

        panel.add(clientLogButton, gbc);

        // Log Admin
        // spacing after the text in button adjust the size of the button
        JButton adminLogButton = new JButton("Log in as Admin    ");
        gbc.gridy = 3;

        panel.add(adminLogButton, gbc);

        // Create Account
        JButton createAccountButton = new JButton("Create an Account");
        gbc.gridy = 4;

        panel.add(createAccountButton, gbc);

        // Exit
        // spacing after the text in button adjust the size of the button
        JButton exitButton = new JButton("Exit program         ");
        gbc.gridy = 5;

        panel.add(exitButton, gbc);

        // Events Listeners on button

        clientLogButton.addActionListener(e -> {
            role = "client";
            panel.setVisible(false);
            AuthenticationPage.ShowGUI(role, myMarket);
        });

        adminLogButton.addActionListener(e -> {
            role = "admin";
            panel.setVisible(false);
            AuthenticationPage.ShowGUI(role, myMarket);
        });

        createAccountButton.addActionListener(e -> {
            role = "Create";
            panel.setVisible(false);
            AuthenticationPage.ShowGUI(role, myMarket);
        });

        exitButton.addActionListener(e -> System.exit(0));
    }

}
