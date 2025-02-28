package Bai2;

public class TrainTicketSystem {
    public static void main(String[] args) {
        TicketSeller seller = new TicketSeller();

        Thread agency1 = new Thread(seller, "Đại lý 1");
        Thread agency2 = new Thread(seller, "Đại lý 2");
        Thread agency3 = new Thread(seller, "Đại lý 3");

        agency1.start();
        agency2.start();
        agency3.start();
    }
}
