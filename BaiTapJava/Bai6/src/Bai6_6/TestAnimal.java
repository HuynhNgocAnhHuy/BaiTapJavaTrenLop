package Bai6_6;

public class TestAnimal {
	public static void main(String[] args) {
        Animal cat = new Cat("Kitty");
        Animal dog = new Dog("Rex");
        Dog dog2 = new Dog("Max");
        BigDog bigDog = new BigDog("Bruno");
        BigDog bigDog2 = new BigDog("Rocky");

        cat.greets();                
        dog.greets();                
        dog2.greets();               
        dog2.greets((Dog) dog);      
        bigDog.greets();             
        bigDog.greets(dog2);         
        bigDog.greets(bigDog2);      
    }
}
