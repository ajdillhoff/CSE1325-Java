public class NumberFormatExceptionTest {
    public static void main(String[] args) {
        try {
            int val = Integer.parseInt("test");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
