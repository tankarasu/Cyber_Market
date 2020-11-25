package com.company;

import com.company.store.ProductList_Page;
import com.company.views.AdminInterface;
import com.company.views.AdminInterface_Page;
import com.company.views.ClientInterface_Page;

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
                //LandingPage.ShowGUI();
                //ClientInterface_Page.ShowGUI();
                //AdminInterface_Page.ShowGUI();
                ProductList_Page.ShowGUI();
            }
        });
    }
}
