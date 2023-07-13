import java.util.HashMap;

public class HashMapExamples {
    public static void main(String[] args) {
        // Create a new HashMap of Item
        var items = new HashMap<Integer, Item>();

        // Add a new Item to the map
        items.put(0, new Item(0, "Item1"));

        // Retrieve the number of items in the HashMap
        System.out.println("The HashMap has " + items.size() + " element(s).");

        // Get an item by key
        Item item = items.get(0);

        System.out.println(item);

        // Remove an object by key
        items.remove(0);

        // Clear the entire map
        items.clear();

        // Create a new HashMap of Item using the Item's name as they key
        var itemsByName = new HashMap<String, Item>();

        // Add a new Item to the map
        itemsByName.put("Item1", new Item(0, "Item1"));

        // Retrieve the number of items in the HashMap
        System.out.println("The HashMap has " + itemsByName.size() + " element(s).");

        // Get an item by key
        Item itemByName = itemsByName.get("Item1");

        System.out.println(itemByName);

        // Remove an object by key
        itemsByName.remove("Item1");

        // Clear the entire map
        itemsByName.clear();
    }
}
