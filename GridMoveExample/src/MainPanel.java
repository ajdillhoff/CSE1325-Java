import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainPanel extends JPanel implements ContainerListener {
    private GridComponent[] gridComponents;
    private ArrayList<SpriteComponent> sprites;
    private SpriteMoveListener spriteMoveListener;
    private int numRows = 10;
    private int numCols = 10;

    public MainPanel() {
        super();
        setSize(new Dimension(1000, 1000));
        setLayout(new GridLayout(numRows, numCols));

        sprites = new ArrayList<>();
        gridComponents = new GridComponent[100];

        for (int i = 0; i < 100; i++) {
            gridComponents[i] = new GridComponent(i);
            gridComponents[i].addContainerListener(this);
            add(gridComponents[i]);
        }
    }

    public int addSprite(String path, int x, int y) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            SpriteComponent sprite = new SpriteComponent(sprites.size());
            sprite.setImage(image);
            sprite.setSpriteMoveListener(spriteMoveListener);
            sprites.add(sprite);
            int gridIdx = getGridIdx(x, y);
            gridComponents[gridIdx].setSprite(sprite);
            return sprites.size() - 1;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    private int getGridIdx(int x, int y) {
        return y * numCols + x;
    }

    public void addSpriteMoveListener(SpriteMoveListener listener) {
        this.spriteMoveListener = listener;
    }

    /**
     * Converts pixel coordinates to the grid location.
     * @param x relative x pixel value with respect to the frame.
     * @param y relative y pixel value with respect to the frame.
     * @return A <code>Point</code> containing the grid location.
     */
    public Point getGridLocation(int x, int y) {
        int gridWidth = gridComponents[0].getWidth();
        int gridHeight = gridComponents[0].getHeight();

        return new Point(x / gridWidth, y / gridHeight);
    }

    @Override
    public void componentAdded(ContainerEvent containerEvent) {
        if (containerEvent.getContainer() instanceof GridComponent) {
            var gridComponent = (GridComponent) containerEvent.getContainer();
            if (containerEvent.getChild() instanceof SpriteComponent) {
                SpriteComponent spriteComponent = (SpriteComponent) containerEvent.getChild();
                int x = gridComponent.getId() % numCols;
                int y = gridComponent.getId() / numRows;
                spriteMoveListener.spriteMoved(spriteComponent.getId(), x, y);
            }
        }
    }

    @Override
    public void componentRemoved(ContainerEvent containerEvent) {

    }
}
