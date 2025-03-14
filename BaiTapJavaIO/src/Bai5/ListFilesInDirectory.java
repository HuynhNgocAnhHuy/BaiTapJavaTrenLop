package Bai5;
import java.io.File;

	public class ListFilesInDirectory {
	    public static void main(String[] args) {
	        String directoryPath = "D:\\baitapjava\\baitapjavaIOstream\\src\\bai5\\file\\"; 
	        
	        File directory = new File(directoryPath);
	        
	        if (directory.exists() && directory.isDirectory()) {
	            File[] files = directory.listFiles();
	            
	            if (files != null && files.length > 0) {
	                System.out.println("Danh sách các tệp trong thư mục: " + directoryPath);
	                for (File file : files) {
	                    if (file.isFile()) {
	                        System.out.println("[File] " + file.getName());
	                    } else if (file.isDirectory()) {
	                        System.out.println("[Thư mục] " + file.getName());
	                    }
	                }
	            } else {
	                System.out.println("Thư mục trống hoặc không có tệp nào.");
	            }
	        } else {
	            System.out.println("Thư mục không tồn tại hoặc không hợp lệ.");
	        }
	    }
	}



