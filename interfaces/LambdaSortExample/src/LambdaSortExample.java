import java.util.Arrays;

public class LambdaSortExample {
    public static void main(String[] args) {
        User[] users = {
                new User(1, "Naomi Nagata"),
                new User(2, "James Holden"),
                new User(3, "Amos Burton"),
                new User(4, "Alex Kamal"),
                new User(5, "Clarissa Mao")
        };

        // Sort by id descending
        Arrays.sort(users, (first, second) -> second.getId() - first.getId());

        System.out.println("Sorted by id...");
        for (var user : users) {
            System.out.println(user);
        }

        // Sort by name length
        Arrays.sort(users, (first, second) -> first.getName().length() - second.getName().length());

        System.out.printf("\nSorted by name length...\n");
        for (var user : users) {
            System.out.println(user);
        }
    }
}
