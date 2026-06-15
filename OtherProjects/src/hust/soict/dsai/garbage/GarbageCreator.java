package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Exercise 9: GarbageCreator
 * Reads a binary/text file into a String using "+" operator in a loop.
 *
 * Problem:
 *   Every iteration allocates a new String object (old one becomes garbage).
 *   For large files the JVM heap fills up with unreachable String objects,
 *   forcing frequent GC pauses and potentially causing OutOfMemoryError.
 *
 * Run with a large file (e.g. a video or ISO image) and observe the slowness.
 * Compare execution time with NoGarbage which uses StringBuilder instead.
 */
public class GarbageCreator {

    public static void main(String[] args) throws IOException {

        // Replace with any large file path to observe the problem
        String filename = "test.txt";

        // Create a sample test file if it does not exist
        if (!java.nio.file.Files.exists(Paths.get(filename))) {
            StringBuilder gen = new StringBuilder();
            for (int i = 0; i < 100_000; i++) gen.append("Hello World! ");
            Files.write(Paths.get(filename), gen.toString().getBytes());
        }

        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        long startTime = System.currentTimeMillis();

        // ❌ BAD: creates a new String object on every "+" – generates lots of garbage
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("GarbageCreator (String \"+\") time (ms): " + (endTime - startTime));
        System.out.println("Output length: " + outputString.length());
    }
}
