package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

/**
 * Exercise 7: Tests for Store class.
 * Tests: addDVD(), removeDVD()
 */
public class StoreTest {

    public static void main(String[] args) {

        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);

        // Test addDVD
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        System.out.println("\nAfter adding 3 DVDs:");
        store.print();

        // Test removeDVD – existing item
        store.removeDVD(dvd2);
        System.out.println("\nAfter removing Star Wars:");
        store.print();

        // Test removeDVD – item not in store
        store.removeDVD(dvd2);  // already removed – should print "not found"
    }
}
