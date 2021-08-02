import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageView extends JPanel {
    private BufferedImage img;

    public ImageView(String filename) {
        try {
            File imgFile = new File(filename);
            img = ImageIO.read(imgFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (img != null) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        }
    }
}
