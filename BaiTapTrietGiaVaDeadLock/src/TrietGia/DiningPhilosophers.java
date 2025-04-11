package TrietGia;

import java.util.concurrent.Semaphore;

public class DiningPhilosophers {
    private final Semaphore[] chopsticks = new Semaphore[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            chopsticks[i] = new Semaphore(1);
        }
    }

    public void startDinner(int philosopherId) {
        try {
            while (true) {
                think(philosopherId);
                pickUpChopsticks(philosopherId);
                eat(philosopherId);
                putDownChopsticks(philosopherId);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think(int id) throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void pickUpChopsticks(int id) throws InterruptedException {
        int leftChopstick = id;
        int rightChopstick = (id + 1) % 5;

        if (id % 2 == 0) {
            chopsticks[leftChopstick].acquire();
            chopsticks[rightChopstick].acquire();
        } else {
            chopsticks[rightChopstick].acquire();
            chopsticks[leftChopstick].acquire();
        }

        System.out.println("Philosopher " + id + " picked up chopsticks " + leftChopstick + " and " + rightChopstick);
    }

    private void eat(int id) throws InterruptedException {
        System.out.println("Philosopher " + id + " is eating.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void putDownChopsticks(int id) {
        int leftChopstick = id;
        int rightChopstick = (id + 1) % 5;
        chopsticks[leftChopstick].release();
        chopsticks[rightChopstick].release();
        System.out.println("Philosopher " + id + " put down chopsticks.");
    }
}
