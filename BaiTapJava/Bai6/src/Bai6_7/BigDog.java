package Bai6_7;

public class BigDog extends Dog{
	@Override
    public void greeting() {
        System.out.println("Ồ!");
    }

    @Override
    public void greeting(Dog another) {
        System.out.println("Woooooooowww!");
    }

    public void greeting(BigDog another) {
        System.out.println("Woooooooowww!");
    }
}
