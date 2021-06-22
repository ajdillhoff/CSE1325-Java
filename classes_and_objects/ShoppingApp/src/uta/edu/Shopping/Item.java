package uta.edu.Shopping;

/**
 * Represents an <code>Item</code> in an inventory system.
 */
public class Item {
    private int id;
    private String name;
    private double price;

    /**
     * Create a new <code>Item</code>.
     * @param id Unique identifier.
     * @param name Name of the item.
     * @param price Current price of the item.
     */
    public Item(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
