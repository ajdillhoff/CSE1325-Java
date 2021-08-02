import javax.swing.*;
import java.awt.*;

public class GridLayoutExample extends JFrame {
    final static int numCols = 5;
    final static int numRows = 5;

    public GridLayoutExample() {
        setLayout(new GridLayout(numRows, numCols));

        for (int i = 0; i < (numRows * numCols); i++) {
            add(new Button("" + (i + 1)));
        }

        setTitle("Grid Layout Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GridLayoutExample();
        });
    }
}
