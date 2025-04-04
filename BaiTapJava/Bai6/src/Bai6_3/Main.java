package Bai6_3;

public class Main {
	public static void main(String[] args) {
        MovablePoint point = new MovablePoint(0, 0, 2, 3);

        System.out.println("Ban đầu: " + point);
        point.moveUp();
        System.out.println("Sau khi moveUp: " + point);
        point.moveRight();
        System.out.println("Sau khi moveRight: " + point);
        point.moveDown();
        System.out.println("Sau khi moveDown: " + point);
        point.moveLeft();
        System.out.println("Sau khi moveLeft: " + point);
    }
}
