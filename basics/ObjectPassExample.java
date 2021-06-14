import java.util.Date;

/**
 * Shows examples of passing objects as method parameters.
 * Object references are copied, not the objects themselves.
 * @version 1.0 2021-06-14
 * @author Alex Dillhoff
 */
public class ObjectPassExample {
    public static void addOneDay(Date d) {
        d.setTime(d.getTime() + 86_400_000);
    }

    public static void swapDates(Date d1, Date d2) {
        System.out.println("  swapDates()");
        System.out.println("  Before swap...");
        System.out.printf("  d1 = %s\n", d1);
        System.out.printf("  d2 = %s\n", d2);

        Date temp = d1;
        d1 = d2;
        d2 = temp;

        System.out.println("  After swap...");
        System.out.printf("  d1 = %s\n", d1);
        System.out.printf("  d2 = %s\n", d2);
    }

    public static void main(String[] args) {
        Date d1 = new Date();

        // A reference of the object is passed.
        // Using an instance method allows the underlying object to be modified.
        System.out.printf("Original date: %s\n", d1);
        addOneDay(d1);
        System.out.printf("Modified date: %s\n", d1);

        Date d2 = new Date();

        // The references inside swapDate are passed, but those are only copies.
        // The original object references are unchanged.
        System.out.println("main()");
        System.out.println("Before swapDate()...");
        System.out.printf("d1 = %s\n", d1);
        System.out.printf("d2 = %s\n", d2);

        swapDates(d1, d2);

        System.out.println("After swapDates()...");
        System.out.printf("d1 = %s\n", d1);
        System.out.printf("d2 = %s\n", d2);
    }
}