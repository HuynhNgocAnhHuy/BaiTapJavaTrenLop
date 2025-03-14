package Bai6;
import java.io.*;

public class FileReaderThread extends Thread{
	    private final String inputFile;
	    private final BufferedWriter writer;

	    public FileReaderThread(String inputFile, BufferedWriter writer) {
	        this.inputFile = inputFile;
	        this.writer = writer;
	    }

	    @Override
	    public void run() {
	        synchronized (writer) {
	            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
	                String line;
	                writer.write("--- Nội dung từ file: " + inputFile + " ---\n");
	                while ((line = reader.readLine()) != null) {
	                    writer.write(line);
	                    writer.newLine();
	                }
	                writer.write("\n");
	                System.out.println("Hoàn thành đọc file: " + inputFile);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	} 

	            
	       
	      
