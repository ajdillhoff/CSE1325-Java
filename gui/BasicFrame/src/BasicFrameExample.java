import javax.swing.*;

public class BasicFrameExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BasicFrame frame = new BasicFrame();
                frame.setTitle("BasicFrameExample");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setResizable(false);

                // Add a lightweight component
                JLabel label = new JLabel("Welcome to CSE 1325.");
                frame.add(label);

                frame.setVisible(true);
            }
        });
    }
}
