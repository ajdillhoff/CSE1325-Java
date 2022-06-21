import java.io.*;
import java.util.Scanner;

public class ObjectIOExample {
    public static User createUser() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = in.nextLine();

        System.out.print("Enter your date of birth (yyyy-mm-dd): ");
        String dob = in.nextLine();

        return new User(name, dob);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User u = createUser();

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("user.db"));

        // Serializes the object
        os.writeObject(u);

        os.close();

        // Read the stored data and print it
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("user.db"));

        u = (User) is.readObject();

        System.out.println(u);
    }
}
