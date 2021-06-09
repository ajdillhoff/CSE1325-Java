import java.util.Date;

/**
 * Example of using an object instance.
 * @version 1.0 2021-06-08
 * @author Alex Dillhoff
 */
public class DateExample {
    public static void main(String[] args) {
        // Create an instance of a Date object using one of the constructor methods.
        // With no input, the date value will reflect the time it was created.
        Date today = new Date();

        System.out.println(today);

        // The following declaration does not refer to any object.
        // You should NEVER declare an uninitialize variable.
        // For objects, initialize them to `null`.
        Date unknown;

        // The following line would cause an error
        //System.out.println(unknown);

        // Both `unknown` and `today` refer to the same object.
        unknown = today;

        System.out.printf("Today is %s\n", unknown);
    }
}
