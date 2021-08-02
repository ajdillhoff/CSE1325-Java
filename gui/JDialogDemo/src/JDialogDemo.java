import javax.swing.*;
import java.awt.*;

public class JDialogDemo {
    private JFrame mainFrame;

    public JDialogDemo() {
        mainFrame = new JFrame("JDialog Demo");
        mainFrame.setSize(400, 400);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton button = new JButton("Show Dialog");
        button.addActionListener(actionEvent -> showDialog());
        mainFrame.add(button);

        mainFrame.setVisible(true);
    }

    public void showDialog() {
        JDialog dialog = new JDialog(mainFrame, "New Dialog", true);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setSize(120, 100);

        // Configure location
        Point currentLocation = mainFrame.getLocation();
        currentLocation.x += ((mainFrame.getWidth() / 2) - (dialog.getWidth() / 2));
        currentLocation.y += ((mainFrame.getHeight() / 2) - (dialog.getHeight() / 2));
        dialog.setLocation(currentLocation);

        dialog.setLayout(new FlowLayout());

        JLabel label = new JLabel("WARNING!");
        dialog.add(label);

        JButton button = new JButton("OK");
        button.addActionListener(actionEvent -> dialog.dispose());
        dialog.add(button);

        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JDialogDemo();
        });
    }
}
