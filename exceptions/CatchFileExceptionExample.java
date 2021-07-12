import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CatchFileExceptionExample {
    public static void readFile(String fileName) {
        try {
            File f = new File(fileName);
            Scanner in = new Scanner(f);

            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String fileName = "test.dat";

        readFile(fileName);
    }
}
