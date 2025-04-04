package Bai3_1;
import java.util.Scanner;
public class MyComplexApp {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);

	        System.out.print("Enter complex number 1 (real and imaginary part): ");
	        double real1 = in.nextDouble();
	        double imag1 = in.nextDouble();
	        MyComplex c1 = new MyComplex(real1, imag1);

	        System.out.print("Enter complex number 2 (real and imaginary part): ");
	        double real2 = in.nextDouble();
	        double imag2 = in.nextDouble();
	        MyComplex c2 = new MyComplex(real2, imag2);

	        System.out.println("\nNumber 1 is: " + c1);
	        if (c1.isReal()) {
	            System.out.println(c1 + " is a pure real number");
	        } else {
	            System.out.println(c1 + " is NOT a pure real number");
	        }
	        if (c1.isImaginary()) {
	            System.out.println(c1 + " is a pure imaginary number");
	        } else {
	            System.out.println(c1 + " is NOT a pure imaginary number");
	        }

	        System.out.println("\nNumber 2 is: " + c2);
	        if (c2.isReal()) {
	            System.out.println(c2 + " is a pure real number");
	        } else {
	            System.out.println(c2 + " is NOT a pure real number");
	        }
	        if (c2.isImaginary()) {
	            System.out.println(c2 + " is a pure imaginary number");
	        } else {
	            System.out.println(c2 + " is NOT a pure imaginary number");
	        }

	        System.out.println();
	        if (c1.equals(c2)) {
	            System.out.println(c1 + " is equal to " + c2);
	        } else {
	            System.out.println(c1 + " is NOT equal to " + c2);
	        }

	        MyComplex sum = c1.addNew(c2);
	        System.out.println(c1 + " + " + c2 + " = " + sum);


	        in.close();
	    }
}
