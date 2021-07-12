import java.io.IOException;
import java.util.Scanner;

public class RethrowExceptionExample {
    public static void parseCsvLine(Scanner in) throws IOException {
        String[] rawVals = in.nextLine().trim().split(",");

        try {
            int val = Integer.parseInt(rawVals[0]);
        } catch (NumberFormatException original) {
//            throw new IOException("CSV parse error");

            var e = new IOException("CSV parse error");
            e.initCause(original);
            throw e;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            parseCsvLine(in);
        } catch (IOException e) {
            e.getCause().printStackTrace();
        }
    }
}
