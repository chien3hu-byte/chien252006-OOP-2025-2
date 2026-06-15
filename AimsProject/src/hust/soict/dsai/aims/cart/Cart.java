package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

/**
 * Represents the shopping cart in AIMS.
 *
 * Exercise 2: Overloaded addDigitalVideoDisc methods
 * Exercise 6: print(), searchById(), searchByTitle()
 */
public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;

    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // ----------------------------------------------------------------
    // Exercise 2.1 – Overloading by type: add a single DVD (original)
    // ----------------------------------------------------------------
    public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd;
            qtyOrdered++;
            System.out.println("The disc has been added to cart: " + dvd.getTitle());
        } else {
            System.out.println("The cart is almost full. Cannot add more items.");
        }
    }

    // Exercise 2.1 – Overloading by type: add an array of DVDs
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            addDigitalVideoDisc(dvd);
        }
    }

    // Exercise 2.1 – Overloading with varargs (arbitrary number of DVDs)
    // Varargs is more flexible than array: caller can pass 1, 2, 3, ... DVDs
    // without explicitly creating an array.
    // Preference: varargs is preferred here because it is more concise at call sites.
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        // NOTE: Java resolves the most-specific overload first, so this varargs
        // method is only called when neither the single-DVD nor the two-DVD
        // overload matches.
        for (DigitalVideoDisc dvd : dvds) {
            addDigitalVideoDisc(dvd);
        }
    }

    // ----------------------------------------------------------------
    // Exercise 2.2 – Overloading by number of parameters: add two DVDs
    // ----------------------------------------------------------------
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    // ----------------------------------------------------------------
    // Remove a DVD from the cart
    // ----------------------------------------------------------------
    public boolean removeDigitalVideoDisc(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == dvd) {
                // Shift remaining items left
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("Removed: " + dvd.getTitle());
                return true;
            }
        }
        System.out.println("DVD not found in cart: " + dvd.getTitle());
        return false;
    }

    // ----------------------------------------------------------------
    // Exercise 6: print() – formatted cart listing
    // ----------------------------------------------------------------
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        float totalCost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
            totalCost += itemsOrdered[i].getCost();
        }

        System.out.printf("Total cost: %.2f $%n", totalCost);
        System.out.println("***************************************************");
    }

    // ----------------------------------------------------------------
    // Exercise 6: searchById(int id)
    // ----------------------------------------------------------------
    public void searchById(int id) {
        System.out.println("Searching for DVD with ID = " + id + " ...");
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found: " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with ID = " + id);
        }
    }

    // ----------------------------------------------------------------
    // Exercise 6: searchByTitle(String title)
    // Uses isMatch() defined in DigitalVideoDisc
    // ----------------------------------------------------------------
    public void searchByTitle(String title) {
        System.out.println("Searching for DVD with title containing \"" + title + "\" ...");
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Found: " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with title containing \"" + title + "\"");
        }
    }

    // ----------------------------------------------------------------
    // Getters
    // ----------------------------------------------------------------
    public int getQtyOrdered()              { return qtyOrdered; }
    public DigitalVideoDisc[] getItems()    { return itemsOrdered; }
}
