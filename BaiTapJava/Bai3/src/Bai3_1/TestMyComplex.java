package Bai3_1;

public class TestMyComplex {
	 public static void main(String[] args) {
	        MyComplex c1 = new MyComplex(1.1, 2.2);
	        MyComplex c2 = new MyComplex(3.3, 4.4);

	        System.out.println("c1 = " + c1);  
	        System.out.println("c2 = " + c2);  

	        System.out.println("c1 is real? " + c1.isReal());
	        System.out.println("c1 is imaginary? " + c1.isImaginary());

	        System.out.println("c1 == c2? " + c1.equals(c2));

	        System.out.println("c1 magnitude = " + c1.magnitude());
	        System.out.println("c1 argument (radians) = " + c1.argument());

	        c1.add(c2);
	        System.out.println("c1 after c1.add(c2): " + c1);

	        MyComplex c3 = c1.subtractNew(new MyComplex(1, 1));
	        System.out.println("c1 after c1.subtractNew(...): " + c1);
	        System.out.println("c3 = " + c3);

	        c3.multiply(new MyComplex(2, 2));  
	        System.out.println("c3 after multiply(2+2i): " + c3);

	        c3.divide(new MyComplex(1, 1));
	        System.out.println("c3 after divide(1+1i): " + c3);

	        c3.conjugate();
	        System.out.println("c3 after conjugate(): " + c3);
	    }
}
