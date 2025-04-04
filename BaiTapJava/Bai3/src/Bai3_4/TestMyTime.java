package Bai3_4;

public class TestMyTime {
	public static void main(String[] args) {
        MyTime time = new MyTime(23, 59, 58);
        System.out.println("Thời gian ban đầu: " + time);

        time.nextSecond();
        System.out.println("Sau 1 giây: " + time);
        time.nextSecond();
        System.out.println("Sau 1 giây nữa: " + time);

        time.previousSecond();
        System.out.println("Lùi lại 1 giây: " + time);

        time.nextMinute();
        System.out.println("Sau 1 phút: " + time);

        time.nextHour();
        System.out.println("Sau 1 giờ: " + time);

        time.previousHour();
        System.out.println("Lùi lại 1 giờ: " + time);
    }
}

