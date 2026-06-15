package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

/**
 * Exercise 7: Store class.
 * Contains an array of DVDs available in the store.
 * Supports addDVD and removeDVD operations.
 */
public class Store {

    private static final int MAX_NUMBER_IN_STORE = 100;

    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_NUMBER_IN_STORE];
    private int nbItems = 0;

    // ----------------------------------------------------------------
    // addDVD: add a DVD to the store
    // ----------------------------------------------------------------
    public void addDVD(DigitalVideoDisc dvd) {
        if (nbItems < MAX_NUMBER_IN_STORE) {
            itemsInStore[nbItems] = dvd;
            nbItems++;
            System.out.println("Added to store: " + dvd.getTitle());
        } else {
            System.out.println("Store is full. Cannot add: " + dvd.getTitle());
        }
    }

    // ----------------------------------------------------------------
    // removeDVD: remove a DVD from the store
    // ----------------------------------------------------------------
    public boolean removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < nbItems; i++) {
            if (itemsInStore[i] == dvd) {
                for (int j = i; j < nbItems - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[nbItems - 1] = null;
                nbItems--;
                System.out.println("Removed from store: " + dvd.getTitle());
                return true;
            }
        }
        System.out.println("DVD not found in store: " + dvd.getTitle());
        return false;
    }

    // ----------------------------------------------------------------
    // print: display all DVDs in the store
    // ----------------------------------------------------------------
    public void print() {
        System.out.println("==========  STORE  ==========");
        if (nbItems == 0) {
            System.out.println("(empty)");
        } else {
            for (int i = 0; i < nbItems; i++) {
                System.out.println((i + 1) + ". " + itemsInStore[i].toString());
            }
        }
        System.out.println("==============================");
    }

    // Getters
    public int getNbItems()                     { return nbItems; }
    public DigitalVideoDisc[] getItemsInStore() { return itemsInStore; }
}
