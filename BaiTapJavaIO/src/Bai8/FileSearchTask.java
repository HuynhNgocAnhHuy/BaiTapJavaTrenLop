package Bai8;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
public class FileSearchTask implements Callable<Integer>{
	private final String filePath;
    private final String keyword;

    public FileSearchTask(String filePath, String keyword) {
        this.filePath = filePath;
        this.keyword = keyword.toLowerCase();
    }

    @Override
    public Integer call() {
        int count = 0;
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                count += countOccurrences(line.toLowerCase(), keyword);
            }
            System.out.println("File: " + filePath + " - '" + keyword + "' xuất hiện " + count + " lần.");
        } catch (IOException e) {
            System.err.println("Lỗi đọc file: " + filePath);
        }
        return count;
    }

    private int countOccurrences(String line, String keyword) {
        int index = 0, count = 0;
        while ((index = line.indexOf(keyword, index)) != -1) {
            count++;
            index += keyword.length();
        }
        return count;
    }
}
