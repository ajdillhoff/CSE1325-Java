import java.util.HashSet;

public class HashSetExamples {
    public static void main(String[] args) {
        // Create a new HashSet of Item
        var items = new HashSet<Item>();

        // Add a new Item to the set
        items.add(new Item(0, "Item1"));

        // Retrieve the number of items in the HashSet
        System.out.println("The HashSet has " + items.size() + " element(s).");

        // Look up an item in the HashSet
        Item item = new Item(0, "Item1");
        System.out.println("The HashSet contains the item: " + items.contains(item));

        // Remove an object by reference
        Item itemReference = items.iterator().next(); // Get the first item
        items.remove(itemReference);

        // Clear the entire set
        items.clear();
    }
}
