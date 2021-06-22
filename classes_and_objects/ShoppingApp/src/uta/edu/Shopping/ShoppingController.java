package uta.edu.Shopping;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Interface controller for Shopping app
 */
public class ShoppingController {
    private Customer customer = null;
    private ArrayList<Item> items;
    private ArrayList<Item> cart;
    private Order order = null;

    public ShoppingController() {
        // Dummy data
        items = new ArrayList<Item>();
        items.add(new Item(0, "GeForce GTX 3090", 3499.99));
        items.add(new Item(1, "2021 Apple 11-inch iPad Pro", 899.99));
        items.add(new Item(2, "ASUS TUF Gaming 27\" 165Hz monitor", 369.00));

        Address a = new Address(500, "UTA", "Blvd", "Arlington", "TX", "USA");
        customer = new Customer(0, "Dummy", a, "dummy@uta.edu");
        cart = new ArrayList<>();
    }

    public void showMainMenu() {
        Scanner in = new Scanner(System.in);
        char choice = 0;

        if (isLoggedIn()) {
            System.out.println("S - Shop");
            System.out.println("V - View Cart");
        } else {
            System.out.println("C - Create Customer");
        }
        System.out.println("E - Exit");
        System.out.print("Enter choice: ");
        choice = in.next().toLowerCase().charAt(0);

        switch (choice) {

            case 's':
                if (isLoggedIn()) {
                    showInventory();
                }
                break;
            case 'v':
                if (isLoggedIn()) {
                    showCartView();
                }
                break;
            case 'c':
                showCreateCustomerMenu();
                break;
            case 'e':
                System.exit(0);
            default:
        }
    }

    private void showInventory() {
        Scanner in = new Scanner(System.in);
        cart = new ArrayList<>();

        while (true) {
            int choice = -1;
            showItemListView(items);

            while (choice < 0 || choice > items.size()) {
                System.out.print("Select item (0 to go back): ");
                choice = in.nextInt();
            }

            if (choice != 0) {
                showAddItemView(items.get(choice - 1));
            } else {
                return;
            }
        }
    }

    private void showCartView() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty!");
        } else {
            Scanner in = new Scanner(System.in);
            char menuChoice = 0;

            while (!cart.isEmpty()) {
                showItemListView(cart);

                System.out.println("R - Remove Item");
                System.out.println("O - Place Order");
                System.out.print("> ");
                menuChoice = in.nextLine().toLowerCase().charAt(0);

                switch (menuChoice) {
                    case 'r':
                        while (!cart.isEmpty()) {
                            int itemSelection = -1;

                            while (itemSelection < 0 || itemSelection > cart.size()) {
                                System.out.print("Select item (0 to go back): ");
                                itemSelection = in.nextInt();
                            }

                            if (itemSelection != 0) {
                                showRemoveItemView(cart.get(itemSelection - 1));
                            } else {
                                break;
                            }
                        }
                        break;
                    case 'o':
                        placeOrder();
                        break;
                    default:
                }
            }
        }
    }

    private void showItemListView(ArrayList<Item> items) {
        System.out.printf("| %-30s    | %-8s |\n", "Name", "Price");
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("|%2d. %-30.30s | $%-8.2f|\n", i + 1, items.get(i).getName(), items.get(i).getPrice());
        }
    }

    private void showItemView(Item item) {
        System.out.printf("%10s %s", "Name:", item.getName());
        System.out.printf("%10s $%.2f\n", "Price:", item.getPrice());
    }

    private void showRemoveItemView(Item item) {
        Scanner in = new Scanner(System.in);
        char choice = 0;

        showItemView(item);

        while (choice != 'y' && choice != 'n') {
            System.out.print("Remove item (y/n)? ");
            choice = in.nextLine().toLowerCase().charAt(0);
        }

        if (choice == 'y') {
            cart.remove(item);
        }
    }

    private void showAddItemView(Item item) {
        Scanner in = new Scanner(System.in);
        char choice = 0;

        showItemView(item);

        while (choice != 'y' && choice != 'n') {
            System.out.print("Add to cart (y/n)? ");
            choice = in.nextLine().toLowerCase().charAt(0);
        }

        if (choice == 'y') {
            cart.add(item);
        }
    }

    private void showCreateCustomerMenu() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = in.nextLine();

        System.out.print("Enter street number: ");
        int streetNumber = Integer.parseInt(in.nextLine());

        System.out.print("Enter street name: ");
        String streetName = in.nextLine();

        System.out.print("Enter street type: ");
        String streetType = in.nextLine();

        System.out.print("Enter city: ");
        String city = in.nextLine();

        System.out.print("Enter state: ");
        String state = in.nextLine();

        System.out.print("Enter country: ");
        String country = in.nextLine();

        Address address = new Address(streetNumber, streetName, streetType, city, state, country);

        System.out.print("Enter e-mail: ");
        String email = in.nextLine();

        customer = new Customer(0, name, address, email);

        System.out.printf("Thanks for joining, %s\n", customer.getName());
    }

    private void placeOrder() {
        // Show the items in the cart
        showItemListView(cart);

        // Show shipping address
        System.out.println("Order being shipped to:");
        System.out.println(customer.getAddress());

        // Ask for confirmation
        char choice = 0;
        Scanner in = new Scanner(System.in);

        System.out.print("Place order (Y/n)? ");
        choice = in.nextLine().toLowerCase().charAt(0);

        if (choice == 'n') {
            return;
        }

        Order o = new Order(0, cart);

        // Show order status being changed to processing
        o.processOrder();

        System.out.println(o);

        // Empty the cart
        cart.clear();
    }

    private boolean isLoggedIn() {
        return customer != null;
    }
}
