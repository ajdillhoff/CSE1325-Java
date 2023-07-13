import java.util.LinkedList;
import java.util.Iterator;

public class IteratorExamples {
    public static void main(String[] args) {
        // Create a new LinkedList of Item
        var items = new LinkedList<Item>();

        // Add a new Item to the list
        items.add(new Item(0, "Item1"));

        // Create an iterator
        Iterator<Item> iterator = items.iterator();

        // Iterate over the list
        while (iterator.hasNext()) {
            Item item = iterator.next();
            System.out.println(item);
        }

        // Remove the last item returned by the iterator
        // NOTE: This can only be called once per call to next()
        iterator.remove();
    }
}
