import java.util.TreeSet;
import java.util.NavigableSet;

public class TreeSetExamples {
    public static void main(String[] args) {
        // Create a new TreeSet of Item
        NavigableSet<Item> items = new TreeSet<Item>(new ItemComparator());

        // Add 10 Items to the set
        for (int i = 0; i < 10; i++) {
            items.add(new Item(i, "Item" + i));
        }

        // Retrieve the number of items in the TreeSet
        System.out.println("The TreeSet has " + items.size() + " element(s).");

        // Get the first (lowest) item
        Item firstItem = items.first();

        System.out.println(firstItem);

        // Get the last (highest) item
        Item lastItem = items.last();

        System.out.println(lastItem);

        // Remove an object by reference
        items.remove(firstItem);

        // Clear the entire set
        items.clear();
    }
}
