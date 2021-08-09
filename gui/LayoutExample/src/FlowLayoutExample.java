import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample extends JFrame {
    public FlowLayoutExample() {
        add(new JLabel("Flow Layout Example"));
        add(new JButton("Button1"));
        add(new JButton("Button2"));

        setLayout(new FlowLayout(FlowLayout.LEFT));

        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Flow Layout Example");
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FlowLayoutExample();
        });
    }
}
