package Bai3_6;

public class Container {
	 private int x1, y1, x2, y2;

	    public Container(int x, int y, int width, int height) {
	        this.x1 = x;
	        this.y1 = y;
	        this.x2 = x + width;
	        this.y2 = y + height;
	    }

	    public boolean collidesWith(Ball ball) {
	        float ballX = ball.getX();
	        float ballY = ball.getY();
	        float radius = ball.getRadius();

	        if (ballX - radius < x1 || ballX + radius > x2) {
	            ball.reflectHorizontal();
	            return true;
	        }
	        if (ballY - radius < y1 || ballY + radius > y2) {
	            ball.reflectVertical();
	            return true;
	        }
	        return false;
	    }

	    public String toString() {
	        return "Container[(" + x1 + "," + y1 + ") to (" + x2 + "," + y2 + ")]";
	    }
	}

