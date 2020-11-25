package com.company.store;

import java.util.ArrayList;

public class OrderList {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    private ArrayList<Order> orderArrayList;
    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public OrderList() {

    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    public void addOrder(Order order) {
        getOrderArrayList().add(order);
    }

    public void displayOrders() {
        for (Order order : orderArrayList) {
            // affichage de l'order
        }
    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    public ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


    public void setOrderArrayList(ArrayList<Order> orderArrayList) {
        this.orderArrayList = orderArrayList;
    }
}
