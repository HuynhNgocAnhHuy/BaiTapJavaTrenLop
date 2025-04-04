package Bai3_2;

public class TestMyPolynomial {
	  public static void main(String[] args) {
	        MyPolynomial p1 = new MyPolynomial(1, 2, 3); 
	        MyPolynomial p2 = new MyPolynomial(2, 0, 4, 1); 

	        System.out.println("p1: " + p1);
	        System.out.println("p2: " + p2);

	        System.out.println("Bậc của p1: " + p1.getDegree());
	        System.out.println("Bậc của p2: " + p2.getDegree());

	        System.out.println("Giá trị p1 tại x = 2: " + p1.evaluate(2));
	        System.out.println("Giá trị p2 tại x = 2: " + p2.evaluate(2));

	        MyPolynomial sum = p1.add(p2);
	        System.out.println("p1 + p2 = " + sum);

	        MyPolynomial product = p1.multiply(p2);
	        System.out.println("p1 * p2 = " + product);
	    }
}


