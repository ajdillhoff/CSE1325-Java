import java.util.Arrays;

/**
 * Examples of using multidimensional arrays in Java.
 * @version 1.0 2021-06-03
 * @author Alex Dillhoff
 */
public class MultiDimensionalArrayExample {
    public static void main(String[] args) {
        // Create a 2D array
        int n = 10;
        int m = 20;
        int[][] arr2D = new int[n][m];

        // Create a 2D array using specific values.
        int[][] timesTable = {
            { 1, 2, 3, 4 },
            { 2, 4, 6, 8 },
            { 3, 6, 9, 12 },
            { 4, 8, 12, 16 }
        };

        // Loop through the times table
        for (int[] row : timesTable) {
            for (int val : row) {
                System.out.printf("%2d ", val);
            }
            System.out.println();
        }

        // Print the entire array as a string
        System.out.println(Arrays.deepToString(timesTable));

        // Create a 2D array for which each row has a different length.
        int numRows = 10;
        int[][] arr = new int[numRows][];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[(i + 1) * 2];
            System.out.printf("arr[%d].length = %d\n", i, arr[i].length);
        }
    }
}
