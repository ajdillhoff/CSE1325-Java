/**
 * Shows examples of common numerical conversions.
 * @version 1.0 2021-06-02
 * @author Alex Dillhoff
 */
public class NumericConversionExample {
    public static void main(String[] args) {
        long a = 123456789;
        float b = a; // b will be expressed in exponential notation

        System.out.println(b);

        // Automatic numerical conversions
        // Conversion precedence is: double > float > long > int
        // The following will convert the int to float when evaluating the expression
        int x = 12;
        float y = 3.1f;
        System.out.printf("%d / %f = %f\n", x, y, x / y);

        // Casting between data types
        double f = 3.14;
        System.out.printf("%d\n", (int) f);
    }
}
