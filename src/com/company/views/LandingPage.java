package com.company.views;

import com.company.SpringUtilities;

import javax.swing.*;
import java.awt.*;

public class LandingPage extends JFrame {

    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public LandingPage() throws HeadlessException {

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
        JLabel titleLabel = new JLabel("Welcome dear User");
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 1;

        panel.add(titleLabel, gbc);

        // Log Client
        JButton clientLogButton = new JButton("Log in as Client     ");
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 2;

        panel.add(clientLogButton, gbc);

        // Log Admin
        JButton adminLogButton = new JButton("Log in as Admin    ");
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 3;

        panel.add(adminLogButton, gbc);

        // Create Account
        JButton createAccountButton = new JButton("Create an Account");
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 4;

        panel.add(createAccountButton, gbc);

        // Exit
        JButton exitButton = new JButton("Exit program         ");
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 5;

        panel.add(exitButton, gbc);

    }
    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
