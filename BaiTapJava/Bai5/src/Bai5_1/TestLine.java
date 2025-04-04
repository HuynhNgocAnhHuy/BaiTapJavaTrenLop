package Bai5_1;

public class TestLine {
	public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(4, 6);
        Line l1 = new Line(p1, p2);
        System.out.println(l1);
        System.out.println("Length: " + l1.getLength());
        System.out.println("Gradient: " + l1.getGradient());
    }
}
