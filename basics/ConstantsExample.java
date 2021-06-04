/**
 * Brief example of using constants in Java.
 * @version 1.0 2021-06-01
 * @author Alex Dillhoff
 */
public class ConstantsExample {
    // This constant can be used through all methods in this class.
    public static final int USER_MAX = 100;

    public static void main(String[] args) {
        // This constant can only be used within the scope of main.
        final double SPEED_LIMIT = 60f;

        // In either case, the constants cannot be modified.
        //USER_MAX = 3;

        System.out.printf("Max users: %d\n", USER_MAX);
        System.out.printf("Speed limit: %.0f MPH\n", SPEED_LIMIT);
    }
}
