public interface SpriteMoveListener {
    void spriteMoved(int id, int x, int y);
    boolean canMove(int id);
    boolean canMoveTo(int id, int x, int y);
}
