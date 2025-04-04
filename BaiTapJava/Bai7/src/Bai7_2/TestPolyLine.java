package Bai7_2;
import java.util.ArrayList;
import java.util.List;
public class TestPolyLine {
	public static void main(String[] args) {
        PolyLine l1 = new PolyLine();
        System.out.println(l1);  

        l1.appendPoint(new Point(1, 2));
        l1.appendPoint(3, 4);
        l1.appendPoint(5, 6);
        System.out.println(l1); 

        System.out.println("Length of l1 = " + l1.getLength());

        List<Point> points = new ArrayList<>();
        points.add(new Point(11, 12));
        points.add(new Point(13, 14));
        PolyLine l2 = new PolyLine(points);
        System.out.println(l2);  

        System.out.println("Length of l2 = " + l2.getLength());
    }
}
