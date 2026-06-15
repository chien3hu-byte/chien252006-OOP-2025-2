package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

/**
 * Exercise 6: Tests for Cart methods.
 * Tests: print(), searchById(), searchByTitle()
 * Tests for overloaded addDigitalVideoDisc methods (Exercise 2).
 */
public class CartTest {

    public static void main(String[] args) {

        // Create a new cart
        Cart cart = new Cart();

        // Create new DVD objects
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion Guard",
                "Animation", "Howy Parkins", 60, 15.00f);

        // Exercise 2.1 – add single DVD
        cart.addDigitalVideoDisc(dvd1);

        // Exercise 2.2 – add two DVDs (overloaded with 2 params)
        cart.addDigitalVideoDisc(dvd2, dvd3);

        // Exercise 2.1 – add array of DVDs
        DigitalVideoDisc[] batch = { dvd4 };
        cart.addDigitalVideoDisc(batch);

        System.out.println();

        // Exercise 6 – print cart
        cart.print();

        System.out.println();

        // Exercise 6 – search by ID
        cart.searchById(dvd1.getId());
        cart.searchById(999);   // not found

        System.out.println();

        // Exercise 6 – search by title
        cart.searchByTitle("lion");     // matches dvd1 and dvd4
        cart.searchByTitle("Star");     // matches dvd2
        cart.searchByTitle("Batman");   // no match

        System.out.println();

        // Exercise 5 – classifier member
        System.out.println("Total DVDs created so far: "
                + DigitalVideoDisc.getNbDigitalVideoDiscs());
    }
}
