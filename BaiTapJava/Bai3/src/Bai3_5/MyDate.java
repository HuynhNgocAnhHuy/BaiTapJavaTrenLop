package Bai3_5;

public class MyDate {
	 private int year;
	    private int month;
	    private int day;

	    public static final String[] MONTHS = {
	        "Jan", "Feb", "Mar", "Apr", "May", "Jun",
	        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
	    };

	    public static final String[] DAYS = {
	        "Sunday", "Monday", "Tuesday", "Wednesday",
	        "Thursday", "Friday", "Saturday"
	    };

	    public static final int[] DAYS_IN_MONTHS = {
	        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	    };

	    
	    public MyDate(int year, int month, int day) {
	        setDate(year, month, day);
	    }

	    public static boolean isLeapYear(int year) {
	        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	    }

	    public static boolean isValidDate(int year, int month, int day) {
	        if (year < 1 || year > 9999 || month < 1 || month > 12) return false;
	        int maxDay = DAYS_IN_MONTHS[month - 1];
	        if (month == 2 && isLeapYear(year)) maxDay = 29;
	        return day >= 1 && day <= maxDay;
	    }

	    public static int getDayOfWeek(int year, int month, int day) {
	        if (!isValidDate(year, month, day)) throw new IllegalArgumentException("Invalid date");
	        int y = year;
	        int m = month;
	        if (m < 3) {
	            m += 12;
	            y -= 1;
	        }
	        int k = y % 100;
	        int j = y / 100;
	        int dayOfWeek = (day + (13 * (m + 1)) / 5 + k + (k / 4) + (j / 4) + (5 * j)) % 7;
	        return (dayOfWeek + 6) % 7; 
	    }

	    public void setDate(int year, int month, int day) {
	        if (!isValidDate(year, month, day)) throw new IllegalArgumentException("Năm, tháng hoặc ngày không hợp lệ!");
	        this.year = year;
	        this.month = month;
	        this.day = day;
	    }

	    public int getYear() { return year; }
	    public int getMonth() { return month; }
	    public int getDay() { return day; }

	    public void setYear(int year) {
	        if (year < 1 || year > 9999) throw new IllegalArgumentException("Năm không hợp lệ!");
	        this.year = year;
	    }

	    public void setMonth(int month) {
	        if (month < 1 || month > 12) throw new IllegalArgumentException("Tháng không hợp lệ!");
	        this.month = month;
	    }

	    public void setDay(int day) {
	        if (!isValidDate(year, month, day)) throw new IllegalArgumentException("Ngày không hợp lệ!");
	        this.day = day;
	    }

	    @Override
	    public String toString() {
	        int dayOfWeek = getDayOfWeek(year, month, day);
	        return String.format("%s %d %s %d", DAYS[dayOfWeek], day, MONTHS[month - 1], year);
	    }

	    public MyDate nextDay() {
	        if (isValidDate(year, month, day + 1)) {
	            day++;
	        } else {
	            day = 1;
	            nextMonth();
	        }
	        return this;
	    }

	    public MyDate nextMonth() {
	        if (month == 12) {
	            month = 1;
	            nextYear();
	        } else {
	            month++;
	        }
	        if (!isValidDate(year, month, day)) day = DAYS_IN_MONTHS[month - 1];
	        return this;
	    }

	    public MyDate nextYear() {
	        if (year + 1 > 9999) throw new IllegalStateException("Năm nằm ngoài phạm vi!");
	        year++;
	        if (!isValidDate(year, month, day)) day = 28;
	        return this;
	    }

	    public MyDate previousDay() {
	        if (isValidDate(year, month, day - 1)) {
	            day--;
	        } else {
	            previousMonth();
	            day = DAYS_IN_MONTHS[month - 1];
	            if (month == 2 && isLeapYear(year)) day = 29;
	        }
	        return this;
	    }

	    public MyDate previousMonth() {
	        if (month == 1) {
	            month = 12;
	            previousYear();
	        } else {
	            month--;
	        }
	        if (!isValidDate(year, month, day)) day = DAYS_IN_MONTHS[month - 1];
	        return this;
	    }

	    public MyDate previousYear() {
	        if (year - 1 < 1) throw new IllegalStateException("Năm nằm ngoài phạm vi!");
	        year--;
	        if (!isValidDate(year, month, day)) day = 28;
	        return this;
	    }
	}

