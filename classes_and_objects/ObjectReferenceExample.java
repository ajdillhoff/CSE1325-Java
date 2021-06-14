import java.util.Date;

public class ObjectReferenceExample {
    public static void main(String[] args) {
        Order o = new Order();

        System.out.println(o.getCreationDate());

        Date time = o.getCreationDate();

        // Setting the time here affects the instance field, unless we return a copy.
        time.setTime(10);

        System.out.println(o.getCreationDate());
    }
}
