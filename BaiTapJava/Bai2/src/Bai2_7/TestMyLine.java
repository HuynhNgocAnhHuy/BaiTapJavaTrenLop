package Bai2_7;

public class TestMyLine {
	 public static void main(String[] args) {
	        MyLine line1 = new MyLine(0, 0, 3, 4);
	        System.out.println(line1);
	        System.out.println("Length: " + line1.getLength());
	        System.out.println("Gradient: " + line1.getGradient());

	        line1.setBeginXY(1, 1);
	        line1.setEndXY(4, 5);
	        System.out.println("Updated line: " + line1);
	        System.out.println("Updated Length: " + line1.getLength());
	        System.out.println("Updated Gradient: " + line1.getGradient());

	        MyPoint beginPoint = new MyPoint(2, 2);
	        MyPoint endPoint = new MyPoint(5, 6);
	        MyLine line2 = new MyLine(beginPoint, endPoint);
	        System.out.println(line2);
	        System.out.println("Length: " + line2.getLength());
	        System.out.println("Gradient: " + line2.getGradient());
	    }
}
