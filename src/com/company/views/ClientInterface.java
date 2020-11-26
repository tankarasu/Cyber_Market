package com.company.views;

import com.company.Main;
import com.company.store.Market;
import com.company.store.Product;
import com.company.user.Client;
import com.company.user.User;
import java.util.regex.Pattern;

public class ClientInterface {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    //    static Client client = new Client(); todo delete si nécessaire

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public ClientInterface() {

    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------
    // todo Rajouter case 0 return depuis productlist
    public static void ChoiceMenu(Market myMarket, User client) {
        System.out.println("Welcome " + client.getName() + "\n");
        Product baguette = new Product("baguette", 42, 2);
        String choice;
        // first window of client Interface
        do {
            StringBuilder clientInterfaceMenu = new StringBuilder("");
            clientInterfaceMenu.append("1-List products\n")
                    .append("2-My Cart\n")
                    .append("3-Log Out");
            System.out.println(clientInterfaceMenu);
            choice = Main.getInput();
        } while (!Pattern.matches("^[ ]?[123][ ]?$", choice));

        switch (choice) {
            case "1":
                myMarket.getProductList();
                clientStoreChoice(myMarket, (Client) client);
                ChoiceMenu(myMarket,client);
                // verifier si présence du produit dans Panier todo remanier
                //  boucle
                break;
            case "2":
                // todo case cart empty
                client.getMyCart().getCart(myMarket,client);
                ChoiceMenu(myMarket,client);
                break;
            case "3":
                Menu.chooseRole();
                break;
        }
    }
    // displaying selected product informations
    public static void clientStoreChoice(Market myMarket, Client client) {
        String numberRegex = "^[ ]?[0-9]\\d*[ ]?$";
        String choice;
        Product currentProduct;
        int quantityToAdd = 0;
        int index;
        do {
            System.out.println("Choose a product or Return");
            choice = Main.getInput();
        } while (!Pattern.matches(numberRegex, choice));

        if (choice.equals("0")) return;

        // displaying information of the product
        myMarket.getSpecificProduct(Integer.parseInt(choice) - 1);
        index = Integer.parseInt((choice)) - 1;
        currentProduct =
                myMarket.getTheStore().get(Integer.parseInt(choice) - 1);

        // si valeur entrée non valide reboucle
        do {
            System.out.println("How many product to add to your cart?");
            choice = Main.getInput();
        } while (!Pattern.matches(numberRegex, choice));

        // si valeur entrée = 0 -> return au menu précédent
        if (choice.equals("0")) {
            return;
        }

        // si valeur entrée > quantité disponible on met la quantité max
        // avec message d'avertissement
        if (Integer.parseInt(choice) > currentProduct.getQuantity()) {
            System.out.println("La quantité demandé dépasse le stock " +
                    "disponible, " + currentProduct.getQuantity() + "seront " +
                    "ajoutés au panier");
            quantityToAdd = currentProduct.getQuantity();

            // todo Translate
        }
        // si valeur entrée comprise entre 1 et Quantité disponible incluse
        // on ajuste la quantité à ajouter
        if ((Integer.parseInt(choice) >= 1) & (Integer.parseInt(choice) <= currentProduct.getQuantity())) {
            System.out.println("la quantité demandée sera ajoutée au panier");
            quantityToAdd = Integer.parseInt(choice);
        }

        // on ajoute la Q au cart
        client.getMyCart().addProductToCart(currentProduct, quantityToAdd);

        // on déduit la quantité du stock
        Product storeProduct = myMarket.getTheStore().get(index);
        storeProduct.setQuantity(storeProduct.getQuantity() - quantityToAdd);

        System.out.println("Quantité restant en stock: " + storeProduct.getQuantity() + " pièces");
    }

}
