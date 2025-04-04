package Bai3_6;

public class Ball {
	 private float x, y;
	    private float radius;
	    private float speedX, speedY;

	    public Ball(float x, float y, float radius, float speed, int direction) {
	        this.x = x;
	        this.y = y;
	        this.radius = radius;
	        this.speedX = (float)(speed * Math.cos(Math.toRadians(direction)));
	        this.speedY = (float)(-speed * Math.sin(Math.toRadians(direction)));
	    }

	    public void move() {
	        x += speedX;
	        y += speedY;
	    }

	    public void reflectHorizontal() {
	        speedX = -speedX;
	    }

	    public void reflectVertical() {
	        speedY = -speedY;
	    }

	    public float getX() { return x; }
	    public float getY() { return y; }
	    public float getRadius() { return radius; }
	    public float getSpeedX() { return speedX; }
	    public float getSpeedY() { return speedY; }

	    public String toString() {
	        return "Ball at (" + x + ", " + y + ") with velocity (" + speedX + ", " + speedY + ")";
	    }

		public void setXYZ(float f, float g, float x2) {
			// TODO Auto-generated method stub
			
		}
	}


