import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUIController implements SpriteMoveListener {
    private MainPanel gamePanel;
    private ArrayList<Player> players;

    public GUIController() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GridMoveExample");
        gamePanel = new MainPanel();
        gamePanel.addSpriteMoveListener(this);
        frame.add(gamePanel);
        frame.pack();
        frame.setVisible(true);

        players = new ArrayList<>();
        Player p1 = new Player("Grog");
        Player p2 = new Player("Percy");
        p2.move(5, 5);
        p2.setCurrentMovement(0);
        addPlayer(p1, "assets/7VlpYPm.png");
        addPlayer(p2, "assets/JDrqfVv.png");
    }

    public void addPlayer(Player p, String assetPath) {
        players.add(p);
        int idx = gamePanel.addSprite(assetPath, p.getX(), p.getY());
    }

    @Override
    public void spriteMoved(int id, int x, int y) {
        Player p = players.get(id);
        p.move(x, y);
    }

    @Override
    public boolean canMove(int id) {
        Player p = players.get(id);

        return p.getCurrentMovement() > 0;
    }

    @Override
    public boolean canMoveTo(int id, int x, int y) {
        // incoming x and y are in relative pixel coordinates, convert to grid coordinates
        Point p = gamePanel.getGridLocation(x, y);

        Player player = players.get(id);
        int dx = Math.abs(p.x - player.getX());
        int dy = Math.abs(p.y - player.getY());
        int min = Math.min(dx, dy);
        int max = Math.max(dx, dy);
        int diagonalSteps = min;
        int straightSteps = max - min;

        int distance = (int) (Math.sqrt(2) * diagonalSteps + straightSteps);

        System.out.println("Distance = " + distance);

        return player.getCurrentMovement() >= distance;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUIController::new);
    }
}
