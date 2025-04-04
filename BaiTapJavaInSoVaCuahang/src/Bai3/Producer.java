package Bai3;

public class Producer extends Thread {
    private int id;
    private Buffer buffer;

    public Producer(int id, Buffer buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    public void run() {
        int i = 0;
        while (true) {
            try {
                if (buffer.getCapacity() > buffer.getSize()) {
                    buffer.addProduct(i++, this.id);
                }
                sleep((long) (Math.random() * 100)); // Di chuyển sleep ra ngoài if
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}