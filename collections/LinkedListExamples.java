import java.util.LinkedList;

public class LinkedListExamples {
    public static void main(String[] args) {
        // Create a new LinkedList of Item
        var items = new LinkedList<Item>();

        // Add a new Item to the list
        items.add(new Item(0, "Item1"));

        // Retrieve the number of items in the LinkedList
        System.out.println("The LinkedList has " + items.size() + " element(s).");

        // Add an Item at the start of the list
        items.addFirst(new Item(10, "NewItem"));

        // Add an Item at the end of the list
        items.addLast(new Item(20, "NewItem2"));

        // Remove an object by index
        items.remove(0);

        // Remove an object by reference
        Item itemReference = items.getFirst();
        items.remove(itemReference);

        // Clear the entire list
        items.clear();
    }
}
