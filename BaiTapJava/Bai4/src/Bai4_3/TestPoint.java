package Bai4_3;

public class TestPoint {
	 public static void main(String[] args) {
	        Point2D p2d = new Point2D(1.1f, 2.2f);
	        System.out.println("Point2D: " + p2d);

	        Point3D p3d = new Point3D(3.3f, 4.4f, 5.5f);
	        System.out.println("Point3D: " + p3d);

	        p3d.setXYZ(6.6f, 7.7f, 8.8f);
	        System.out.println("Updated Point3D: " + p3d);
	    }
}
