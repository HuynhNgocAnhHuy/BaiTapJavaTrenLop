package Bai3_6;

public class BouncingBall {
	 public static void main(String[] args) {
	        Ball ball = new Ball(50, 50, 5, 10, 45);
	        Container box = new Container(0, 0, 100, 100);

	        for (int i = 0; i < 100; i++) {
	            ball.move();
	            box.collidesWith(ball);
	            System.out.println(ball);
	        }
	    }
}

	

