package Bai3_7;

public class Player {
	 private int number;   
	    private String name;  
	    private float x;     
	    private float y;      
	    private float z;     

	    public Player() {
	        this.number = 0;
	        this.name = "NoName";
	        this.x = 0.0f;
	        this.y = 0.0f;
	        this.z = 0.0f;
	    }

	    public Player(int number, String name, float x, float y, float z) {
	        this.number = number;
	        this.name = name;
	        this.x = x;
	        this.y = y;
	        this.z = z;
	    }

	    public int getNumber() {
	        return number;
	    }

	    public void setNumber(int number) {
	        this.number = number;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
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

	    public void setPosition(float x, float y, float z) {
	        this.x = x;
	        this.y = y;
	        this.z = z;
	    }

	    public void move(float dx, float dy, float dz) {
	        this.x += dx;
	        this.y += dy;
	        this.z += dz;
	    }

	    public boolean kick(Ball ball) {
	        float dx = this.x - ball.getX();
	        float dy = this.y - ball.getY();
	        float dz = this.z - ball.getZ();
	        double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

	        return distance < 8.0;
	    }

	    @Override
	    public String toString() {
	        return "Player[name=" + name + ", number=" + number +
	               ", position=(" + x + "," + y + "," + z + ")]";
	    }
}
