package Bai6_2;

public class Main {
	public static void main(String[] args) {
        GeometricObject circle = new Circle(5.0);
        GeometricObject rectangle = new Rectangle(4.0, 6.0);

        System.out.println(circle);
        System.out.println("Circle Area: " + circle.getArea());
        System.out.println("Circle Perimeter: " + circle.getPerimeter());

        System.out.println(rectangle);
        System.out.println("Rectangle Area: " + rectangle.getArea());
        System.out.println("Rectangle Perimeter: " + rectangle.getPerimeter());
    }
}
