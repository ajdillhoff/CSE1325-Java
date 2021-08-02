import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class SpriteComponent extends JComponent implements MouseMotionListener, MouseListener {
    private int id;
    private Component source;
    private Container moveContainer;
    private BufferedImage image;
    private Point originalLocation;
    private SpriteMoveListener spriteMoveListener;
    private boolean isDragging = false;

    public SpriteComponent() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public SpriteComponent(int id) {
        this();
        this.id = id;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        repaint();
    }

    public void setSpriteMoveListener(SpriteMoveListener listener) {
        this.spriteMoveListener = listener;
    }

    public void setMoveContainer(Container moveContainer) {
        this.moveContainer = moveContainer;
    }

    public void setSource(Component source) {
        this.source = source;
        this.originalLocation = source.getLocation();
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
        if (image != null) {
            Image image = this.image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            g.drawImage(image, 0, 0, null);
        }
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if (!spriteMoveListener.canMove(id)) {
            return;
        }

        if (!isDragging) {
            isDragging = true;

            GridComponent source = (GridComponent) this.source;
            source.remove(this);
            source.repaint();

            if (moveContainer instanceof JPanel) {
                JPanel panel = (JPanel) moveContainer;
                panel.add(this, 0);

                // Get original location relative to the parent frame
                originalLocation.setLocation(source.getLocation());
            }
        }

        Point convertedPoint = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(convertedPoint, moveContainer);
        int x = convertedPoint.x;
        int y = convertedPoint.y;
        int offsetX = getWidth() / 2;
        int offsetY = getHeight() / 2;
        setLocation(x - offsetX, y - offsetY);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (!isDragging) {
            return;
        }

        Point convertedPoint = SwingUtilities.convertPoint(this, mouseEvent.getPoint(), moveContainer);
        int moveX = convertedPoint.x;
        int moveY = convertedPoint.y;

        // Remove self from dragging container
        moveContainer.remove(this);

        if (!spriteMoveListener.canMoveTo(id, moveX, moveY)) {
            var gridComponent = (GridComponent) source;
            isDragging = false;
            moveContainer.repaint();
            setLocation(0, 0);
            gridComponent.add(this);
            gridComponent.repaint();
            return;
        }

        Component c = SwingUtilities.getDeepestComponentAt(moveContainer, moveX, moveY);

        if (c instanceof GridComponent) {
            GridComponent grid = (GridComponent) c;
            GridComponent source = (GridComponent) this.source;

            // Drop the Sprite
            if (isDragging) {
                isDragging = false;

                JPanel panel = (JPanel) moveContainer;
                panel.remove(this);
                panel.repaint();

                // Sets location relative to the new component it will be in.
                setLocation(0, 0);
            }

            source.remove(this);
            source.setSprite(null);
            source.repaint();
            grid.setSprite(this);
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
