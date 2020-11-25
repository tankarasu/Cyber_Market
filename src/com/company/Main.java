package com.company;

import com.company.views.LandingPage;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LandingPage.ShowGUI();

            }
        });
    }
}
