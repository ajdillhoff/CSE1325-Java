public abstract class Shape {
    protected Position position;

    void move(int x, int y) {
        position.move(x, y);
    }

    public Position getPosition() {
        return position;
    }

    public abstract void draw();

    public final boolean isShape() {
        return true;
    }
}
