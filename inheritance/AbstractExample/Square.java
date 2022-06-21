public class Square extends Shape {
    public final int numPoints = 4;

    public Square(int x, int y) {
        position = new Position(x, y);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Square...");
    }

    // Cannot do this since it was declared `final` in `Shape`
//    @Override
//    public boolean isShape() {
//        return false;
//    }
}
