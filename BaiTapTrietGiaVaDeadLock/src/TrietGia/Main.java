package TrietGia;
import TrietGia.DiningPhilosophers;

import java.util.concurrent.Semaphore;
public class Main{
    public static void main(String[] args) {
        DiningPhilosophers diningPhilosophers = new DiningPhilosophers();

        for (int i = 0; i < 5; i++) {
            final int philosopherId = i;
            new Thread(() -> diningPhilosophers.startDinner(philosopherId)).start();
        }
    }

}