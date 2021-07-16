package ObjectExistsExample;

/**
 * Example adapted from "Java The Complete Reference (Eleventh Edition)" by Herbert Schildt
 */
public class ObjectExistsExample {
    /**
     * Determines if an object exists within a given array.
     * @param x The object to test.
     * @param y The array.
     * @param <T> The type of object to be tested.
     * @param <V> The type of objects in the array.
     * @return true if the object is in the array, false otherwise.
     */
    public static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (int i = 0; i < y.length; i++) {
            if (x.equals(y[i])) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String[] strings = {
                "String1",
                "String2",
                "String3"
        };

        System.out.println(isIn("String1", strings));
        System.out.println(isIn("Test", strings));

        // Will not compile since String does not extend Integer.
//        System.out.println(isIn(3, strings));

        User[] users = {
                new User(0),
                new User(1),
                new User(1)
        };

        // Will not compile since User does not implement Comparable
//        System.out.println(isIn(users[0], users));
    }
}
