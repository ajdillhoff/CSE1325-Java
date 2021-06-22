import uta.edu.Shopping.ShoppingController;

/**
 * Defines the application logic for a shopping app.
 */
public class ShoppingApp {
    public static void main(String[] args) {
        ShoppingController sc = new ShoppingController();

        while (true) {
            sc.showMainMenu();
        }
    }
}
