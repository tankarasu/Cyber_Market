package com.company.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthenticationPage extends JFrame {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public AuthenticationPage() throws HeadlessException {
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------


    public static void ShowGUI() {
        JFrame frame = new JFrame("Authentication Page");
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

        // label
        JLabel nameLabel = new JLabel("user name: ");
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 1;

        panel.add(nameLabel, gbc);

        // textField Nom
        JTextField nameField = new JTextField(15);
        gbc.gridy = 2;

        panel.add(nameField, gbc);

        // label Password
        JLabel password = new JLabel("password: ");
        gbc.gridy = 3;

        panel.add(password, gbc);

        // Textfield Password
        JTextField passwordField = new JTextField(15);
        gbc.gridy = 4;

        panel.add(passwordField, gbc);

        // submit
        JButton submit = new JButton("Log in");
        gbc.gridy = 5;

        panel.add(submit, gbc);

        // submit
        JButton returnButton = new JButton("Return");
        gbc.gridy = 6;

        panel.add(returnButton, gbc);

        // Event listeners
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                ClientInterface_Page.ShowGUI();
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                LandingPage.ShowGUI();
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
