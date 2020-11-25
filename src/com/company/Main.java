package com.company;

import com.company.views.LandingPage;
import com.company.views.Menu;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        /*try {
            Menu.startApp();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LandingPage.ShowGUI();
            }
        });
    }
}
