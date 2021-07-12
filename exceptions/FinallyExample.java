import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FinallyExample {
    public static void readFile(String fileName) {
        try {
            var in = new FileInputStream(fileName);

            try {
                int data = in.read();
            } catch (IOException e) {
                System.out.println("Could not read data.");
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println("Could not close file.");
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readFile("test.dat");
    }
}
