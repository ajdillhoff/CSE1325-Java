/**
 * Example of common operators in Java.
 * @version 1.0 2021-06-02
 * @author Alex Dillhoff
 */
public class OperatorExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        double x = 14.3;
        double y = 3.14;

        // Arithmetic operators
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a / b);
        System.out.println(a * b);
        System.out.println(a % b);

        // Ternery operator
        int c = a > b ? b : a;

        // Increment operators
        a++;
        ++b;
        x--;
        --y;

        // Assignment operators
        x += a;
        b -= x;
        c /= 2;

        // Bit-wise operators
        String s1 = Integer.toBinaryString(a).replaceAll(" ", "0");
        String s2 = Integer.toBinaryString(a << 1).replaceAll(" ", "0");
        String s3 = Integer.toBinaryString(a & b).replaceAll(" ", "0");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        // Short-circuit evaluation
        String str = null;

        // Since the first subexpression returns false,
        // so the second subexpression is not evaluated.
        if (str != null && str.length() > 5) {
            System.out.println(str);
        } else {
            System.out.println("s.length() is never evaluated.");
        }

        // floating-point division by 0
        double r = x / 0;
        System.out.println(r);

        // integer division by 0: throws an exception
        c /= 0;
    }
}
