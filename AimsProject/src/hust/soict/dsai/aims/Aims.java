package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

/**
 * Main class for the AIMS application.
 * Demonstrates the features implemented in Lab 03.
 */
public class Aims {

    public static void main(String[] args) {

        // ---- Create store ----
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);

        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        store.print();

        // ---- Create cart ----
        Cart cart = new Cart();
        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2, dvd3);   // two-param overload

        cart.print();

        cart.searchById(dvd2.getId());
        cart.searchByTitle("lion");
        cart.searchByTitle("xyz");

        // ---- Classifier member demo ----
        System.out.println("Total DVDs created: "
                + DigitalVideoDisc.getNbDigitalVideoDiscs());
    }
}
