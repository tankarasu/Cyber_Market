package com.company.views;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Scanner;

public class AdminInterface {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    static Scanner userInput = new Scanner(System.in);
    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public AdminInterface() {

    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------


    public static void ChoiceMenu() {
        String choice;
        do {
            System.out.println("What do you want to do ?");
            System.out.println("1-List products\n2-Add a Product\n3-Return");
            choice = userInput.next();
        } while (!choice.equalsIgnoreCase("1") & !choice.equalsIgnoreCase("2") & !choice.equalsIgnoreCase("3"));
        switch (choice) {
            case "1":
                break;
            case "2":

                break;
            case "3":
                Menu.chooseRole();
                break;
        }
    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
