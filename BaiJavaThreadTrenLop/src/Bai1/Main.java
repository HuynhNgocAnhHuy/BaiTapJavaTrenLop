package Bai1;

import java.util.concurrent.Semaphore;

public class Main {
        public static void main(String[] args) {
            int n = 5; // Số lượng triết gia
            Semaphore[] chopsticks = new Semaphore[n];

            for (int i = 0; i < n; i++) {
                chopsticks[i] = new Semaphore(1);
            }

            Philosopher[] philosophers = new Philosopher[n];
            for (int i = 0; i < n; i++) {
                Semaphore left = chopsticks[i];
                Semaphore right = chopsticks[(i + 1) % n];

                philosophers[i] = new Philosopher(i, left, right);
                philosophers[i].start();
            }
        }
}
