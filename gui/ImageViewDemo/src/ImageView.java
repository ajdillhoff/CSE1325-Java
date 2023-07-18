import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageView extends JPanel {
    private BufferedImage img;
    private Dimension size;

    public ImageView(String filename) {
        size = getSize();

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
            if (!size.equals(getSize())) {
                size = getSize();
                Image temp = img.getScaledInstance(size.width, size.height, Image.SCALE_DEFAULT);

                // Convert temp to BufferedImage
                img = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = img.createGraphics();
                g2d.drawImage(temp, 0, 0, null);
                g2d.dispose();
            }
            g.drawImage(img, 0, 0, null);
        }
    }
}
