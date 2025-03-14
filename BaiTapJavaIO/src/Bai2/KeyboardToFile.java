package Bai2;

import java.io.*;

public class KeyboardToFile {
    public static void main(String[] args) {
        String fileName = "D:\\baitapjava\\baitapjavaIOstream\\src\\bai2\\output.txt\\";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            System.out.println("Enter text (type 'exit' to stop):");

            String line;
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line);
                writer.newLine(); 
            }

            System.out.println("Data has been written to " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}