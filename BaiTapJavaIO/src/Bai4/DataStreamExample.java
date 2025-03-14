package Bai4;


	import java.io.*;

	public class DataStreamExample {
	    public static void main(String[] args) {
	        String filePath = "D:\\baitapjava\\baitapjavaIOstream\\src\\bai4\\numbers.txt\\";

	        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
	            int[] numbers = {1, 2, 3, 4, 5};
	            
	            for (int number : numbers) {
	                dos.writeInt(number);
	            }
	            System.out.println("Đã ghi xong danh sách số nguyên vào file.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
	            System.out.println("Các số đã đọc từ file:");
	            while (dis.available() > 0) {
	                int number = dis.readInt();
	                System.out.println(number);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}



