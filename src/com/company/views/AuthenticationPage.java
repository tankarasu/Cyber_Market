package com.company.views;

import com.company.Main;
import com.company.store.Market;
import com.company.user.*;

import javax.swing.*;
import java.awt.*;

public class AuthenticationPage extends JFrame {

    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    static ClientDatabase clientDatabase;
    static UserDatabase userDatabase;

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public AuthenticationPage() throws HeadlessException {

    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    public static void ShowGUI(String role, Market myMarket) {


        userDatabase = (UserDatabase) Main.isDeSerialized("UserDatabase");
        if (userDatabase == null) {
            System.out.println("restored userDatabase EMPTY");
            userDatabase = new UserDatabase();
        }
        clientDatabase = (ClientDatabase) Main.isDeSerialized("ClientDatabase");
        if (clientDatabase == null) {
            System.out.println("restored clientDatabase EMPTY");
            clientDatabase = new ClientDatabase();
        }

        AdminDatabase adminDatabase = new AdminDatabase();

        // customize title of the page
        String title = "";
        if (role.equals("admin"))
            title = "Admin login Page";
        else if (role.equals("client"))
            title = "Client login Page";
        else
            title = "Create an Account";

        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null);

        addComponentsToFrame(frame,
                role,
                clientDatabase,
                myMarket,
                clientDatabase,
                adminDatabase);

        frame.setVisible(true);
    }

    public static void addComponentsToFrame(Container panel,
                                            String role,
                                            ClientDatabase client,
                                            Market myMarket,
                                            ClientDatabase clientDatabase,
                                            UserDatabase adminDatabase) {
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

        // textField Name
        JTextField nameField = new JTextField(15);
        gbc.gridy = 2;

        panel.add(nameField, gbc);

        // label Password
        JLabel password = new JLabel("password: ");
        gbc.gridy = 3;

        panel.add(password, gbc);

        // Textfield Password
        JPasswordField passwordField = new JPasswordField(15);
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
        submit.addActionListener(e -> {
            int index;
            // client log in
            if (role.equals("client")) {
                index = Auth.isUserRegistered(
                        clientDatabase,
                        nameField.getText(),
                        passwordField.getText());
                if (index == -1) {
                    AuthenticationPage.ShowGUI("client", myMarket);
                } else {
                    panel.setVisible(false);
                    ClientInterface_Page.ShowGUI(client.getM_aUserList().get(index),
                            myMarket);
                }
                // Admin log in
            } else if (role.equals("admin")) {
                index = Auth.isUserRegistered(
                        adminDatabase,
                        nameField.getText(),
                        passwordField.getText());
                if (index == -1) {
                    AuthenticationPage.ShowGUI("client", myMarket);
                } else {
                    panel.setVisible(false);
                    AdminInterface_Page.ShowGUI(myMarket);
                }
            } else {
                // create an account
                Auth.createAccount(
                        clientDatabase,
                        userDatabase,
                        nameField.getText(),
                        passwordField.getText());
                nameField.setText("");
                passwordField.setText("");
            }

        });

        returnButton.addActionListener(e -> {
            panel.setVisible(false);
            LandingPage.ShowGUI();
        });
    }

}
