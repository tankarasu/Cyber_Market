package com.company.store;

public class Product {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    private String m_sName;
    private int m_iQuantity;
    private double m_iPrice;

    // -------------------------------------------------
    // constructor
    // -------------------------------------------------

    public Product(String name, int quantity, double price) {
        setM_sName(name);
        setQuantity(quantity);
        setM_iPrice(price);
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    public String getName() {
        return m_sName;
    }

    public int getQuantity() {
        return m_iQuantity;
    }

    public double getPrice() {
        return m_iPrice;
    }

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


    public void setM_sName(String m_sName) {
        this.m_sName = m_sName;
    }

    public void setQuantity(int m_iQuantity) {
        this.m_iQuantity = m_iQuantity;
    }

    public void setM_iPrice(double m_iPrice) {
        this.m_iPrice = m_iPrice;
    }
}
