import java.util.ArrayList;
import java.util.Arrays;

/**
 * Demonstrates some common methods of the ArrayList class.
 */
public class ArrayListExamples {
    public static void main(String[] args) {
        // Create a new ArrayList of Item
        var items = new ArrayList<Item>();

        // Add a new String to the list
        items.add(new Item(0, "Item1"));

        // Retrieve the number of items in the ArrayList
        System.out.println("The array list has " + items.size() + " element(s).");

        // Add all elements from a different Collection to this ArrayList
        // The Array must be converted to a Collection type first
        Item[] otherItems = {
                new Item(1, "Item2"),
                new Item(2, "Item2"),
                new Item(3, "Item2"),
                new Item(4, "Item2"),
        };

        items.addAll(Arrays.asList(otherItems));

        // Create a shallow copy -- the elements are not copied
        var itemsCopy = (ArrayList<Item>) items.clone();

        // Iterate and prove that each element refers to the same
        System.out.println("Showing comparison of objects after shallow copy.");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i) == itemsCopy.get(i));
        }

        // Change the value at a specific index
        items.set(1, new Item(10, "Changed Item"));

        System.out.println("Showing modified ArrayList.");
        for (var item : items) {
            System.out.println(item);
        }

        // Convert the collection to a standard Array
        Item[] itemsArray = items.toArray(new Item[0]);

        // Remove an object by index
        items.remove(0);

        System.out.println("Removed item at index 0.");
        for (var item : items) {
            System.out.println(item);
        }

        // Remove an object by reference
        Item itemReference = items.get(0);

        items.remove(itemReference);

        System.out.println("Removed item " + itemReference);
        for (var item : items) {
            System.out.println(item);
        }

        // Clear the entire list
        items.clear();
    }
}
