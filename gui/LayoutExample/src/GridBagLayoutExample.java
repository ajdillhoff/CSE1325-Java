import javax.swing.*;
import java.awt.*;

public class GridBagLayoutExample extends JFrame {
    public GridBagLayoutExample() {
        JLabel mainLabel = new JLabel("GridBagLayout Example");
        JButton button1 = new JButton("Button1");
        JButton button2 = new JButton("Button2");

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Configure label with constraints
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        // Need to specify a non-zero weighty
        c.weighty = 0.1;
        c.anchor = GridBagConstraints.NORTHWEST;
        add(mainLabel, c);

        // Configure first button with constraints
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 0.1;
        add(button1, c);

        // Configure second button with constraints
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 1;
        add(button2, c);

        setTitle("GridBagLayoutExample");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GridBagLayoutExample();
        });
    }
}
