import java.io.*;
import java.util.*;
import java.nio.file.Path;

/**
 * Examples of reading from and writing to files in Java.
 * @version 1.0 2021-06-03
 * @author Alex Dillhoff
 */
public class FileExample {
    // "throws IOException" allows us to ignore handling the I/O errors
    // for now. We'll learn about exception handling later on.
    public static void main(String[] args) throws IOException {
        // Create a new file and write to it.
        PrintWriter writer = new PrintWriter("out.txt");

        // The PrintWriter class support writing of each primitive type
        writer.print(10);  // integer
        writer.print('\n');  // character (newline)
        writer.println(3.15);  // float/double
        writer.println(true);  // boolean
        writer.println("An entire string.");  // String

        writer.close();

        // Open the file for reading
        // We must use Path.of() so the Scanner knows it is a file path.
        Scanner in = new Scanner(Path.of("out.txt"));

        // Check if the next input is an integer
        if (in.hasNextInt()) {
            int value = in.nextInt();
            System.out.println(value);
        }

        if (in.hasNextDouble()) {
            System.out.printf("%f\n", in.nextDouble());
        }

        if (in.hasNextBoolean()) {
            System.out.println(in.nextBoolean());
        }

        // Skip the newline after the boolean was printed.
        in.skip("\n");

        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
        }

        in.close();
    }
}
