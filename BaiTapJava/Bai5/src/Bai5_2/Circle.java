package Bai5_2;

public class Circle {
	 private double radius;
	    private String color;

	    // Constructor mặc định
	    public Circle() {
	        this.radius = 1.0;
	        this.color = "red";
	    }

	    // Constructor với tham số
	    public Circle(double radius, String color) {
	        this.radius = radius;
	        this.color = color;
	    }

	    public double getRadius() {
	        return radius;
	    }

	    public String getColor() {
	        return color;
	    }

	    public double getArea() {
	        return Math.PI * radius * radius;
	    }
	}

