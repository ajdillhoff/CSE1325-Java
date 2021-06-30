public class Triangle extends Shape {
    public final int numPoints = 3;

    public Triangle(int x, int y) {
        position = new Position(x, y);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Triangle...");
    }
}
