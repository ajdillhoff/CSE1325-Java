package ArrayListExample;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList strings = new ArrayList();

        for (int i = 0; i < 10; i++) {
            strings.add("String " + (i + 1));
        }

        for (int i = 0; i < strings.size(); i++) {
            System.out.println((String) strings.get(i));
        }

        System.out.printf("Capacity: %d\n", strings.capacity());

        // Add one more to trigger a resize
        strings.add("New String");

        System.out.printf("Size: %d\n", strings.size());
        System.out.printf("New Capacity: %d\n", strings.capacity());
    }
}
