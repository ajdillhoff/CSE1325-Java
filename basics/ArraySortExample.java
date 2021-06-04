import java.util.*;

/**
 * Example of sorting arrays in Java.
 * @version 1.0 2021-06-03
 * @author Alex Dillhoff
 */
public class ArraySortExample {
    public static void main(String[] args) {
        double[] arr = { 3.2, 1.6, -3.5, 10.3, 9.7, 0.001, 3.85 };

        // Unsorted
        System.out.println("Unsorted");
        for (double v : arr) {
            System.out.printf("%.1f ", v);
        }
        System.out.println();

        // Sort the array with Arrays.sort
        Arrays.sort(arr);

        // Sorted
        System.out.println("Sorted");
        for (double v : arr) {
            System.out.printf("%.1f ", v);
        }
        System.out.println();
    }
}
