package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

/**
 * Exercise 3: Demonstrates Java's pass-by-value semantics.
 * Exercise 4: Debugged with Eclipse (see answers.txt for observations).
 *
 * Key points:
 *  - swap(Object, Object) does NOT swap the caller's references because Java
 *    passes a COPY of the reference value, not the reference itself.
 *  - changeTitle() DOES change the object's state because both the local
 *    parameter and the caller's variable point to the SAME object – the method
 *    mutates the object's internal field via the copied reference.
 */
public class TestPassingParameter {

    public static void main(String[] args) {

        DigitalVideoDisc jungleDVD     = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // Attempt to swap – will NOT work (pass-by-value)
        swap(jungleDVD, cinderellaDVD);
        System.out.println("After swap(jungleDVD, cinderellaDVD):");
        System.out.println("  jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("  cinderella dvd title: " + cinderellaDVD.getTitle());

        // changeTitle – WILL work because we mutate the object via the reference copy
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("\nAfter changeTitle(jungleDVD, cinderellaDVD.getTitle()):");
        System.out.println("  jungle dvd title: " + jungleDVD.getTitle());

        // ----------------------------------------------------------------
        // Exercise 3 – correct swap using a wrapper array
        // ----------------------------------------------------------------
        DigitalVideoDisc[] ref1 = { new DigitalVideoDisc("Movie A") };
        DigitalVideoDisc[] ref2 = { new DigitalVideoDisc("Movie B") };

        System.out.println("\nBefore correct swap:");
        System.out.println("  ref1 title: " + ref1[0].getTitle());
        System.out.println("  ref2 title: " + ref2[0].getTitle());

        correctSwap(ref1, ref2);

        System.out.println("After correct swap:");
        System.out.println("  ref1 title: " + ref1[0].getTitle());
        System.out.println("  ref2 title: " + ref2[0].getTitle());
    }

    // ----------------------------------------------------------------
    // Original swap – does NOT work
    // Both o1 and o2 are local copies of the references.
    // Swapping the copies has no effect on the caller's variables.
    // ----------------------------------------------------------------
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    // ----------------------------------------------------------------
    // changeTitle – DOES work
    // dvd is a copy of the reference, but it still points to the same object.
    // Calling dvd.setTitle() mutates the object that the caller's variable
    // also references.
    // Note: the last line "dvd = new DigitalVideoDisc(oldTitle)" only
    // reassigns the local copy – it does NOT affect the caller.
    // ----------------------------------------------------------------
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle); // this line has no effect outside
    }

    // ----------------------------------------------------------------
    // Exercise 3: correct swap using single-element arrays as wrappers
    // Arrays are objects; we mutate element [0] of the wrapper array.
    // ----------------------------------------------------------------
    public static void correctSwap(DigitalVideoDisc[] ref1, DigitalVideoDisc[] ref2) {
        DigitalVideoDisc tmp = ref1[0];
        ref1[0] = ref2[0];
        ref2[0] = tmp;
    }
}
