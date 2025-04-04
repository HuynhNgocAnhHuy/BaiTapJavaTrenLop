package Bai6_5;

public class TestResizableCircle {
	 public static void main(String[] args) {
	        ResizableCircle resizableCircle = new ResizableCircle(10);
	        System.out.println(resizableCircle);
	        resizableCircle.resize(50);
	        System.out.println("After resizing by 50%:");
	        System.out.println(resizableCircle);
	        System.out.println("Perimeter: " + resizableCircle.getPerimeter());
	        System.out.println("Area: " + resizableCircle.getArea());
	    }
}
