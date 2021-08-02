import javax.swing.*;

public class JListDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DemoController();
        });
    }
}
