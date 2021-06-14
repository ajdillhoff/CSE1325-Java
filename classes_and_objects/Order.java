import java.util.Date;

public class Order {
    private Date creationDate;

    public Order() {
        creationDate = new Date();
    }

    /**
     * Returns a reference to the instance field.
     * @return creationDate
     */
    public Date getCreationDate() {
//        return creationDate;

        // Solution
        return (Date) creationDate.clone();
    }
}
