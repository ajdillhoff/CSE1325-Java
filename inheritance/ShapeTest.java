public class ShapeTest {
    public static void main(String[] args) {
        Triangle t = new Triangle(5, 5);
        Square s = new Square(4, 4);

        Shape[] shapes = { s, t };

        for (var shape : shapes) {
            shape.draw();
        }
    }
}
