package Bai3;

public class Consumer extends Thread {
    private int id;
    private Buffer buffer;

    public Consumer(int id, Buffer buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            try {
                if (buffer.getSize() > 0) {
                    buffer.removeProduct(this.id);
                }
                sleep((long) (Math.random() * 100));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}