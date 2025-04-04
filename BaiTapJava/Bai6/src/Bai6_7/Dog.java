package Bai6_7;

public class Dog extends Animal{
	 @Override
	    public void greeting() {
	        System.out.println("Gâu!");
	    }

	    public void greeting(Dog another) {
	        System.out.println("Gâu gâu!");
	    }
}
