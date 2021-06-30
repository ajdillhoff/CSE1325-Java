public class Square extends Shape {
    public final int numPoints = 4;

    public Square(int x, int y) {
        position = new Position(x, y);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Square...");
    }
}
