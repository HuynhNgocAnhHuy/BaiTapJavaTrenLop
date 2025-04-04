package Bai6_4;

public class Main {
	public static void main(String[] args) {
        MovableCircle circle = new MovableCircle(0, 0, 2, 3, 5);

        System.out.println("Ban đầu: " + circle);
        circle.moveUp();
        System.out.println("Sau khi moveUp: " + circle);
        circle.moveRight();
        System.out.println("Sau khi moveRight: " + circle);
        circle.moveDown();
        System.out.println("Sau khi moveDown: " + circle);
        circle.moveLeft();
        System.out.println("Sau khi moveLeft: " + circle);
    }
}
