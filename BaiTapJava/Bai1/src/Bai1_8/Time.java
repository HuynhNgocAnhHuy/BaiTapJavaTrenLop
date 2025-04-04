package Bai1_8;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return this.second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public Time nextSecond() {
        second++; // Tăng giây lên 1
        if (second == 60) {
            second = 0;
            minute++;
        }

        if (minute == 60) {
            minute = 0;
            hour++;
        }

        if (hour == 24) {
            hour= 0; // Reset về 0 nếu vượt qua 23 giờ

        }

        return this; // Trả về chính đối tượng để hỗ trợ method chaining
    }

    public Time previousSecond() {
        second--;
        if (second < 0) {
            second = 59;
            minute--;
        }

        if (minute < 0) {
                minute = 59;
                hour--;
        }

        if (hour < 0) {
            hour = 23; // Quay lại 23:59:59 nếu đang ở 00:00:00
        }
        return this; // Trả về đối tượng hiện tại để hỗ trợ method chaining
    }



}
