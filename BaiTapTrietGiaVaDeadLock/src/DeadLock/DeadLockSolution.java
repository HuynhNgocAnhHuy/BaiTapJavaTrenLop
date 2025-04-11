package DeadLock;

import DeadLock.Resource;

public class DeadLockSolution {
    public static void main(String[] args) {
        Resource resource1 = new Resource();
        Resource resource2 = new Resource();

        Runnable task1 = () -> {
            synchronized (resource1) {
                System.out.println("Thread A locked resource1");

                try { Thread.sleep(50); } catch (InterruptedException e) {}

                synchronized (resource2) {
                    System.out.println("Thread A locked resource2");
                }
            }
        };

        Runnable task2 = () -> {
            synchronized (resource1) {
                System.out.println("Thread B locked resource1");

                try { Thread.sleep(50); } catch (InterruptedException e) {}

                synchronized (resource2) {
                    System.out.println("Thread B locked resource2");
                }
            }
        };

        Thread threadA = new Thread(task1);
        Thread threadB = new Thread(task2);

        threadA.start();
        threadB.start();
    }

}