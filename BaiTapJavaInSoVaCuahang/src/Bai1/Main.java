package Bai1;

public class Main {

    public static void main(String[] args) {
        int maxNumber = 10; // Số tối đa muốn in
        NumberPrinter printer = new NumberPrinter(maxNumber);

        Thread oddThread = new Thread(() -> printer.printOdd());
        Thread evenThread = new Thread(() -> printer.printEven());

        oddThread.start();
        evenThread.start();
    }
}
