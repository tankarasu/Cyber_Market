package com.company.views;

import com.company.user.AdminDatabase;
import com.company.user.ClientDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthenticationPage extends JFrame {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    static ClientDatabase clientDatabase = new ClientDatabase();
    static AdminDatabase adminDatabase = new AdminDatabase();
    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public AuthenticationPage() throws HeadlessException {
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------


    public static void ShowGUI(String role) {
        JFrame frame = new JFrame("Authentication Page");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(760, 640);
        frame.setLocationRelativeTo(null);

        addComponentsToFrame(frame, role);

        frame.setVisible(true);
    }

    public static void addComponentsToFrame(Container panel, String role) {
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
                int index = 0;
                // client log in
                if (role.equals("client")) {
                    index = Auth.isUserRegistered(
                            clientDatabase,
                            nameField.getText(),
                            passwordField.getText());
                    if (index == -1) {
                        AuthenticationPage.ShowGUI("client");
                    } else {
                        panel.setVisible(false);
                        ClientInterface_Page.ShowGUI();
                    }
                    // Admin log in
                } else if (role.equals("admin")) {
                    index = Auth.isUserRegistered(
                            adminDatabase,
                            nameField.getText(),
                            passwordField.getText());
                    if (index == -1) {
                        AuthenticationPage.ShowGUI("client");
                    } else {
                        panel.setVisible(false);
                        AdminInterface_Page.ShowGUI();
                    }
                } else {
                    // create an account
                    Auth.createAccount(
                            clientDatabase,
                            nameField.getText(),
                            passwordField.getText());
                    nameField.setText("");
                    passwordField.setText("");
                }
                // todo Errors Handling

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
