package ObjectEqualityExample;

public class ObjectEqualityExampleMain {
    public static void main(String[] args) {
        User user1 = new User(0);
        Object user2 = new User(0);

        System.out.println(user1.equals(user2));
    }
}
