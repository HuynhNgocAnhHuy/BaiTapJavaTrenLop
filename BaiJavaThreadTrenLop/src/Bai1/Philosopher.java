package Bai1;
import java.util.concurrent.Semaphore;
public class Philosopher extends Thread{
    private int id;
    private Semaphore leftChopstick;
    private Semaphore rightChopstick;

    public Philosopher(int id, Semaphore leftChopstick, Semaphore rightChopstick) {
        this.id = id;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    private void think() throws InterruptedException {
        System.out.println("Triet gia " + id + " dang suy nghi...");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void eat() throws InterruptedException {
        System.out.println("Triet gia " + id + " dang an...");
        Thread.sleep((long) (Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                if (leftChopstick.tryAcquire()) {
                    if (rightChopstick.tryAcquire()) {
                        eat();
                        rightChopstick.release();
                    }
                    leftChopstick.release();
                }
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
