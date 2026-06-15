package hust.soict.dsai.garbage;

import java.util.Random;

/**
 * Exercise 9: ConcatenationInLoops
 * Compares the performance of String "+" concatenation vs StringBuilder.
 *
 * Result observation:
 *  - String "+" in a loop creates a new String object on every iteration
 *    (old objects become garbage immediately) → very slow.
 *  - StringBuilder.append() modifies an internal char array in-place → very fast.
 */
public class ConcatenationInLoops {

    public static void main(String[] args) {

        // ---- Method 1: String "+" operator ----
        Random r = new Random(123);
        long start = System.currentTimeMillis();

        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }

        long timeWithPlus = System.currentTimeMillis() - start;
        System.out.println("String \"+\" operator time (ms): " + timeWithPlus);
        // Typically prints roughly 4500 ms

        // ---- Method 2: StringBuilder ----
        r = new Random(123);
        start = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();

        long timeWithStringBuilder = System.currentTimeMillis() - start;
        System.out.println("StringBuilder time (ms):       " + timeWithStringBuilder);
        // Typically prints roughly 5 ms

        System.out.printf("%nStringBuilder is approx. %dx faster than \"+\" in this loop.%n",
                timeWithPlus / Math.max(1, timeWithStringBuilder));
    }
}
