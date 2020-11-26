package com.company;

import com.company.views.LandingPage;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(LandingPage::ShowGUI);
    }
}
