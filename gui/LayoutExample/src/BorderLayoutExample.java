import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample extends JFrame {
    public BorderLayoutExample() {
        add(new JButton("Button1"), BorderLayout.NORTH);
        add(new JButton("Button2"), BorderLayout.WEST);
        add(new JLabel("CSE1325"), BorderLayout.CENTER);

        setTitle("Border Layout Example");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public Insets getInsets() {
        return new Insets(40, 20, 20, 20);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BorderLayoutExample();
        });
    }
}
