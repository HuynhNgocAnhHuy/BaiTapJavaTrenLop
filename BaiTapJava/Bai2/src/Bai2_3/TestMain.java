package Bai2_3;

public class TestMain {
	 public static void main(String[] args) {
	        // Kiểm tra lớp Author
	        Author a1 = new Author("Tan Ah Teck", "ahteck@nowhere.com");
	        System.out.println(a1);

	        a1.setEmail("ahteck@somewhere.com");
	        System.out.println(a1);
	        System.out.println("tên là: " + a1.getName());
	        System.out.println("email là: " + a1.getEmail());

	        // Kiểm tra lớp Book
	        Book b1 = new Book("12345", "Java dành cho người mới bắt đầu", a1, 8.8, 88);
	        System.out.println(b1);

	        b1.setPrice(9.9);
	        b1.setQty(99);
	        System.out.println(b1);
	        System.out.println("isbn là: " + b1.getIsbn());
	        System.out.println("tên là: " + b1.getName());
	        System.out.println("giá là: " + b1.getPrice());
	        System.out.println("số lượng là: " + b1.getQty());
	        System.out.println("tác giả là: " + b1.getAuthor());
	        System.out.println("tên tác giả: " + b1.getAuthorName());
	        System.out.println("tên tác giả: " + b1.getAuthor().getName());
	        System.out.println("email của tác giả: " + b1.getAuthor().getEmail());
	    }
}
