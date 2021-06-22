package uta.edu.Shopping;

import java.util.ArrayList;
import java.util.Date;

/**
 * Stores information related to an <code>Order</code> placed in a shopping system.
 */
public class Order {
    private int id;
    private ArrayList<Item> items;
    private Date createdDate;
    private OrderStatus orderStatus;
    private Date shippedDate = null;
    private Date deliveredDate = null;

    /**
     * Create a new <code>Order</code> given a list of <code>Item</code>s.
     * @param id The unique ID of the order.
     * @param items The list of <code>Item</code>s from the cart.
     * @see uta.edu.Shopping.Item
     */
    public Order(int id, ArrayList<Item> items) {
        this.id = id;
        this.items = items;
        this.orderStatus = OrderStatus.PENDING;
        this.createdDate = new Date();
    }

    public void processOrder() {
        if (orderStatus.ordinal() < OrderStatus.PROCESSING.ordinal()) {
            orderStatus = OrderStatus.PROCESSING;
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", items=" + items +
                ", createdDate=" + createdDate +
                ", orderStatus=" + orderStatus +
                ", shippedDate=" + shippedDate +
                ", deliveredDate=" + deliveredDate +
                '}';
    }
}
