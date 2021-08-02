import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GridComponent extends JComponent {
    private int id;
    private SpriteComponent sprite;

    public GridComponent(int id) {
        this.id = id;
        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(blackLine);
    }

    public void setSprite(SpriteComponent sprite) {
        this.sprite = sprite;

        if (sprite != null) {
            sprite.setSource(this);
            sprite.setMoveContainer(this.getParent());
            add(sprite);
            repaint();
        }
    }

    public int getId() {
        return this.id;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (sprite != null) {
            sprite.setSize(getWidth(), getHeight());
        }
    }
}
