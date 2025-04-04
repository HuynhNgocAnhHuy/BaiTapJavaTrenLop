package Bai5_2;

public class Cylinder {
	 private Circle base;
	    private double height;

	    // Constructor mặc định
	    public Cylinder() {
	        this.base = new Circle();
	        this.height = 1.0;
	    }

	    // Constructor với tham số
	    public Cylinder(double radius, String color, double height) {
	        this.base = new Circle(radius, color);
	        this.height = height;
	    }

	    public double getHeight() {
	        return height;
	    }

	    public double getVolume() {
	        return base.getArea() * height;
	    }

	    public String getBaseColor() {
	        return base.getColor();
	    }
	}

