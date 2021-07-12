import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MultipleExceptionExample {
    public static void readFile(String fileName) {
        try {
            var in = new FileInputStream(fileName);

            // Attempt some  read operations
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open the file.");
            e.printStackTrace();
        } catch (SecurityException e) {
            System.out.println("Access denied!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String fileName = "test.dat";

        readFile(fileName);
    }
}
