/**
 * Shows common math functions and constants in Java.
 * @version 1.0 2021-06-02
 * @author Alex Dillhoff
 */
public class MathExample {
    public static void main(String[] args) {
        // Common functions
        System.out.printf("Math.abs(-13.4) = %f\n", Math.abs(-13.4));
        System.out.printf("Math.sqrt(9.0) = %f\n", Math.sqrt(9.0));
        System.out.printf("Math.min(4, 5) = %d\n", Math.min(4, 5));
        System.out.printf("Math.max(10, 100) = %d\n", Math.max(10, 100));
        System.out.printf("Math.exp(3.14) = %f\n", Math.exp(3.14));
        System.out.printf("Math.ceil(8.2) = %f\n", Math.ceil(8.2));
        System.out.printf("Math.abs(1.78) = %f\n", Math.cos(1.78));

        // Common constants
        System.out.printf("Math.E = %f\n", Math.E);
        System.out.printf("\u03c0 = %f\n", Math.PI);
    }
}
