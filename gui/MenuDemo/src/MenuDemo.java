import javax.swing.*;

public class MenuDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MenuController();
        });
    }
}
