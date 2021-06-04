import java.util.*;
import java.io.Console;

/**
 * Examples using the Scanner class.
 * @version 1.0 2021-06-03
 * @author Alex Dillhoff
 */
public class ScannerExample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = in.nextLine();

        System.out.printf("You entered \"%s\"\n", input);

        System.out.print("Enter an integer: ");
        long value = in.nextLong();

        System.out.print("Enter a real number: ");
        double number = in.nextDouble();

        // Starting with Java 6, you can use the Console class for accepting protected in put like passwords
        Console cons = System.console();

        String username = cons.readLine("User name: ");
        // After you're done with password, it is recommended to overwrite
        // the data in the character array so that it is no longer in memory.
        char[] password = cons.readPassword("Password: ");
    }
}
