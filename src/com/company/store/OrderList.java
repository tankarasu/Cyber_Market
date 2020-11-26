package com.company.store;

import com.company.user.Cart;

import java.util.ArrayList;

public class OrderList {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    public ArrayList<Order> orderArrayList;
    ArrayList<Product> cart = new ArrayList<>();
    Order order= new Order("Julietta",cart);
    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public OrderList() {
        orderArrayList = new ArrayList<>();
        orderArrayList.add(order);
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    /*public void addOrder(Order order) {
        getOrderArrayList(order);
    }*/

    public void displayOrders() {
        for (Order order : getOrderArrayList()) {
            System.out.println(order.getClientCartContent() + order.getClientName());

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


//    public void setOrderArrayList(ArrayList<Order> orderArrayList) {
//        this.orderArrayList = orderArrayList;
//    }
}
