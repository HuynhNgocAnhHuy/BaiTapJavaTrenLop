package Bai2;

public class TicketSeller  implements Runnable {
    private static int tickets = 10;
    private static final Object lock = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " bán vé: " + tickets--);
                } else {
                    System.out.println(Thread.currentThread().getName() + " thấy vé đã hết.");
                    break;
                }
            }
        }
    }
}
