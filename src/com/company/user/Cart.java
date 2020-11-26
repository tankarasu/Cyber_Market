package com.company.user;

import com.company.store.Product;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    public ArrayList<Product> m_aCart;


    // -------------------------------------------------
    // constructor
    // -------------------------------------------------

    public Cart() {
        m_aCart = new ArrayList<>();
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    public void addProductToCart(Product p_pProduct, int p_iProductQuantity) {
        Product cartProduct = new Product(p_pProduct.getName(),
                p_iProductQuantity, p_pProduct.getPrice());
        m_aCart.add(cartProduct);
    }

}
