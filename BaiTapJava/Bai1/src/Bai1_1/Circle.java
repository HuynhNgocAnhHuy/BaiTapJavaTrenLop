package Bai1_1;

public class Circle {
    // Private attributes
    private double radius = 1.0;
    private String color = "red";

    // Constructors
    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    // Getter methods
    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    // Setter methods
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Method to calculate area
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // toString method
    @Override
    public String toString() {
        return "Circle[radius=" + radius + ",color=" + color + "]";
    }
}