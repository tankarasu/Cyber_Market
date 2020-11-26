package com.company;

import com.company.store.Market;
import com.company.user.ClientDatabase;
import com.company.user.UserDatabase;
import com.company.views.LandingPage;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LandingPage.ShowGUI();


            }
        });
    }

    public static Object isDeSerialized(String className){
        File currentDir = new File(".");
        File[] saveFiles = currentDir.listFiles(new FilenameFilter() { //Browse the current folder
            public boolean accept(File dir, String name) {
                //Add each file that matches the object type we want to a list
                return name.equalsIgnoreCase(className+"Save.txt");
            }
        });
        if(saveFiles.length!=0){
            for (File file : saveFiles) { //Instantiates an object type according to the input parameter passed to this function
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                    switch(className){
                        case "Market":
                            Market productListMarket = (Market)objectInputStream.readObject();
                            System.out.println("Recovered: "+file);
                            return productListMarket;
                        case "ClientDatabase":
                            ClientDatabase clientDatabase= (ClientDatabase)objectInputStream.readObject();
                            System.out.println("Recovered: "+file);
                            return clientDatabase;
                        case "UserDatabase":
                            UserDatabase userDatabase = (UserDatabase)objectInputStream.readObject();
                            System.out.println("Recovered: "+file);
                            return userDatabase;
                        /*case "Product":
                            Product product = (Product)objectInputStream.readObject();
                           return Product;*/
                    }
                    //closing the stream
                    objectInputStream.close();
                    System.out.println("No case matched! Please check the parameter passed to this function");
                } catch (Exception e) {
                    System.out.println("Deserialization failure: "+className+" Details: "+e);
                }
            }

        }else{
            System.out.println("The following file type couldn't be found: "+className);
        }
        return null;
    }

    public static void serialize(Object object){
        try {
            //Creating stream and writing the object
            FileOutputStream fileOutputStream = new FileOutputStream(object.getClass().getSimpleName()+"Save.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            //closing the stream
            objectOutputStream.close();
            System.out.println("serialized");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String getInput() {
        String input=null;
        Scanner sc= new Scanner(System.in);
        try {
            input = sc.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return input;
    }
}