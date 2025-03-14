package Bai7;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class FileReaderTask implements Runnable{
	private String filePath;
    private long start;
    private long size;
    private byte[] buffer;
    private int index;
    private FileOutputStream output;

    public FileReaderTask(String filePath, long start, long size, int index, FileOutputStream output) {
        this.filePath = filePath;
        this.start = start;
        this.size = size;
        this.index = index;
        this.output = output;
        this.buffer = new byte[(int) size];
    }	

    @Override
    public void run() {
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "r")) {
            raf.seek(start);
            raf.read(buffer);
            synchronized (output) {
                output.write(buffer);
                System.out.println("Đã đọc xong phần: " + index);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
