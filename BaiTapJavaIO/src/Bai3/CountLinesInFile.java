package Bai3;


	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;

	public class CountLinesInFile {
	    public static void main(String[] args) {
	        String filePath = "D:\\baitapjava\\baitapjavaIOstream\\src\\bai3\\input.txt\\";  

	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            int lineCount = 0;

	            while ((line = reader.readLine()) != null) {
	                lineCount++;
	            }

	            System.out.println("Số dòng trong file: " + lineCount);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}


