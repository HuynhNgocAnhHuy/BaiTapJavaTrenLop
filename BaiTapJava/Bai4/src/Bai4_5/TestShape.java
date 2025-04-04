package Bai4_5;

public class TestShape {
	public static void main(String[] args) {
        Shape shape = new Shape("red", false);
        System.out.println(shape);

        Circle circle = new Circle(5.5, "blue", true);
        System.out.println(circle);
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());

        Rectangle rectangle = new Rectangle(2.0, 4.0, "yellow", true);
        System.out.println(rectangle);
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());

        Square square = new Square(3.0, "purple", false);
        System.out.println(square);
        square.setSide(4.5);
        System.out.println("Updated Square: " + square);
    }
}
