package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Exercise 9: NoGarbage
 * Reads the same file as GarbageCreator but uses StringBuilder.append()
 * instead of the "+" operator.
 *
 * Why it is better:
 *   StringBuilder keeps an internal resizable char array.
 *   append() modifies that array in-place, so no intermediate String objects
 *   are created → no garbage, dramatically faster for large inputs.
 */
public class NoGarbage {

    public static void main(String[] args) throws IOException {

        String filename = "test.txt";

        // Create the sample file if missing (same as GarbageCreator)
        if (!Files.exists(Paths.get(filename))) {
            StringBuilder gen = new StringBuilder();
            for (int i = 0; i < 100_000; i++) gen.append("Hello World! ");
            Files.write(Paths.get(filename), gen.toString().getBytes());
        }

        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        long startTime = System.currentTimeMillis();

        // ✅ GOOD: StringBuilder.append() – no new String created per iteration
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }
        String result = outputStringBuilder.toString();

        long endTime = System.currentTimeMillis();
        System.out.println("NoGarbage (StringBuilder) time (ms): " + (endTime - startTime));
        System.out.println("Output length: " + result.length());
    }
}
