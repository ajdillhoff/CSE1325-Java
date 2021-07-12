import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryWithResourcesExample {
    public static void readFile(String fileName) throws IOException {
        try (var in = new FileInputStream(fileName)) {
            int data = in.read();
        }
    }

    public static void main(String[] args) {
        try {
            readFile("test.dat");
        } catch (FileNotFoundException e) {
            System.out.println("Could not open the file.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read any data.");
            e.printStackTrace();
        }
    }
}
