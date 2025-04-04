package Bai3_7;

public class Ball {
	 private float x;
	    private float y;
	    private float z;

	    public Ball() {
	        this.x = 0.0f;
	        this.y = 0.0f;
	        this.z = 0.0f;
	    }

	    public Ball(float x, float y, float z) {
	        this.x = x;
	        this.y = y;
	        this.z = z;
	    }

	    public float getX() {
	        return x;
	    }

	    public float getY() {
	        return y;
	    }

	    public float getZ() {
	        return z;
	    }

	    public void setX(float x) {
	        this.x = x;
	    }

	    public void setY(float y) {
	        this.y = y;
	    }

	    public void setZ(float z) {
	        this.z = z;
	    }

	    public void setXYZ(float x, float y, float z) {
	        this.x = x;
	        this.y = y;
	        this.z = z;
	    }

	    @Override
	    public String toString() {
	        return "(" + x + "," + y + "," + z + ")";
	    }
}
