import java.util.*;

/**
 * Demonstrates common usages of Arrays in Java.
 * @version 1.0 2021-06-04
 * @author Alex Dillhoff
 */
public class ArrayExample {
    public static void main(String[] args) {
        // Array declaration
        int[] arr;

        // Array definition
        arr = new int[20];

        // Assigning a value
        arr[10] = 10;

        // Iterating through the array
        // Note that `length` is a property, not a method.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        // Iterating using a "for-each" loop
        for (int value : arr) {
            System.out.printf("%d ", value);
        }
        System.out.println();

        // A reference copy. Both arrays refer to the same data.
        int[] newArr = arr;

        // This will change the original value in `arr`
        newArr[0] = 100;
        System.out.printf("arr[0]: %d\nnewArr[0] = %d\n", arr[0], newArr[0]);

        // A true copy
        newArr = Arrays.copyOf(arr, arr.length);

        // These values will now be different.
        newArr[0] = 50;
        System.out.printf("arr[0]: %d\nnewArr[0] = %d\n", arr[0], newArr[0]);

        // Anonymous arrays can be declared which can be used to re-initialize existing arrays.
        arr = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        System.out.printf("arr now has %d elements.\n", arr.length);
    }
}
