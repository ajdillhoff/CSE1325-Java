/**
 * A simple Item class to use with the ArrayListExamples file.
 */
public class Item {
    private int id;
    private String name;

    public Item(int i, String n) {
        id = i;
        name = n;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
