package Bai8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadedKeywordSearch {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Nhập danh sách file
	        System.out.println("Nhập số lượng file:");
	        int numFiles = Integer.parseInt(scanner.nextLine());
	        List<String> filePaths = new ArrayList<>();
	        for (int i = 0; i < numFiles; i++) {
	            System.out.println("Nhập đường dẫn file " + (i + 1) + ":");
	            filePaths.add(scanner.nextLine());
	        }

	        // Nhập từ khóa cần tìm
	        System.out.println("Nhập từ khóa cần tìm:");
	        String keyword = scanner.nextLine();

	        // Sử dụng ExecutorService với số luồng tối đa = số file
	        ExecutorService executor = Executors.newFixedThreadPool(filePaths.size());
	        List<Future<Integer>> results = new  ArrayList<>();

	        for (String filePath : filePaths) {
	            results.add(executor.submit(new FileSearchTask(filePath, keyword)));
	        }

	        // Tổng hợp kết quả
	        int totalOccurrences = 0;
	        for (Future<Integer> result : results) {
	            try {
	                totalOccurrences += result.get();
	            } catch (InterruptedException | ExecutionException e) {
	                ((Throwable) e).printStackTrace();
	            }
	        }

	        executor.shutdown();
	        System.out.println("Tổng số lần xuất hiện của '" + keyword + "': " + totalOccurrences);
	    }
}
