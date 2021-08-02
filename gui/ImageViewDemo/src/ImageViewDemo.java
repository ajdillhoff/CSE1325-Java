import javax.swing.*;

public class ImageViewDemo {
    public ImageViewDemo() {
        JFrame frame = new JFrame("ImageView Demo");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(200, 200);

        ImageView imageView = new ImageView("UTA_A-logo.jpg");
        frame.add(imageView);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ImageViewDemo();
        });
    }
}
