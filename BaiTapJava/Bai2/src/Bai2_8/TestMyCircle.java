package Bai2_8;

public class TestMyCircle {
	 public static void main(String[] args) {
	        MyCircle c1 = new MyCircle();
	        System.out.println(c1);

	        MyCircle c2 = new MyCircle(2, 3, 5);
	        System.out.println(c2);

	        MyPoint p = new MyPoint(4, 5);
	        MyCircle c3 = new MyCircle(p, 7);
	        System.out.println(c3);

	        c3.setRadius(10);
	        c3.setCenterXY(1, 1);
	        System.out.println("Radius: " + c3.getRadius());
	        System.out.println("Center: " + c3.getCenter());
	        System.out.println("Area: " + c3.getArea());
	        System.out.println("Circumference: " + c3.getCircumference());

	        System.out.println("Distance between c2 and c3: " + c2.distance(c3));
	    }
}
