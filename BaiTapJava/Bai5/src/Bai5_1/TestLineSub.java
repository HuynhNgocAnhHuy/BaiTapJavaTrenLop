package Bai5_1;

public class TestLineSub {
	public static void main(String[] args) {
        LineSub line = new LineSub(1, 2, 4, 6);
        System.out.println(line);
        System.out.println("Length: " + line.getLength());
        System.out.println("Gradient: " + line.getGradient());
    }
}
