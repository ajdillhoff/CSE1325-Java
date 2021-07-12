import java.io.IOException;
import java.util.Scanner;

public class ThrowExceptionExample {
    public static void parseCsvLine(Scanner in) throws IOException {
        String[] rawVals = in.nextLine().trim().split(",");

        // CSV line must have 3 values
        if (rawVals.length < 3) {
            throw new IOException("error: CSV line must have 3 attributes.");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        parseCsvLine(in);
    }
}
