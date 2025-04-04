package Bai1_1;

public class TestMain {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println(c1);
        System.out.println("Area: " + c1.getArea());

        Circle c2 = new Circle(2.5);
        System.out.println(c2);
        System.out.println("Area: " + c2.getArea());

        Circle c3 = new Circle(3.0, "blue");
        System.out.println(c3);
        System.out.println("Area: " + c3.getArea());
    }
}

