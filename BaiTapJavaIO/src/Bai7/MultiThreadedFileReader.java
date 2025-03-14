package Bai7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedFileReader {
	private static final int CHUNK_SIZE = 1024 * 1024; // 1MB

    public static void main(String[] args) {
        String inputFilePath = "D:\\baitapjava\\baitapjavaIOstream\\src\\bai7\\input.txt\\";
        String outputFilePath = "D:\\baitapjava\\baitapjavaIOstream\\src\\bai7\\output.txt\\";

        try (RandomAccessFile file = new RandomAccessFile(inputFilePath, "r");
             FileOutputStream output = new FileOutputStream(outputFilePath)) {

            long fileSize = file.length();
            int numChunks = (int) Math.ceil((double) fileSize / CHUNK_SIZE);
            ExecutorService executor = Executors.newFixedThreadPool(4); // 4 luồng

            for (int i = 0; i < numChunks; i++) {
                long start = i * CHUNK_SIZE;
                long size = Math.min(CHUNK_SIZE, fileSize - start);
                executor.execute(new FileReaderTask(inputFilePath, start, size, i, output));
            }

            executor.shutdown();
            while (!executor.isTerminated()) { }
            System.out.println("Hoàn thành việc đọc file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
