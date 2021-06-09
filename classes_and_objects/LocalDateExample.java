import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Example using the LocalDate class.
 * @version 1.0 2021-06-08
 * @author Alex Dillhoff
 */
public class LocalDateExample {
    public static void main(String[] args) {
        // LocalDate does not have a constructor.
        // Instead, a factory method is used.
        LocalDate today = LocalDate.now();

        // LocalDate has more convenient methods than the Date class.
        LocalDate yesterday = today.minusDays(1);

        System.out.printf("Today is %s\nYesterday was %s\n", today, yesterday);

        // The LocalDate class provides methods for comparison.
        if (today.equals(yesterday)) {
            System.out.println("Today and yesterday are the same.\n");
        } else {
            System.out.println("Today is not the same as yesterday.\n");
        }

        // There is also a class that incorporates the current time as well
        LocalDateTime now = LocalDateTime.now();
    }
}
