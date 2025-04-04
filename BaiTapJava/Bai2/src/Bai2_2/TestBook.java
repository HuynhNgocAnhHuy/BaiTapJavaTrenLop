package Bai2_2;

public class TestBook {
	public static void main(String[] args) {
        Author[] authors = new Author[2];
        authors[0] = new Author("Tan Ah Teck", "AhTeck@somewhere.com", 'm');
        authors[1] = new Author("Paul Tan", "Paul@nowhere.com", 'm');

        Book javaDummy = new Book("Java dành cho người mới bắt đầu", authors, 19.99, 99);
        System.out.println(javaDummy); 
        System.out.println("Tên sách: " + javaDummy.getName());
        System.out.println("Tên tác giả: " + javaDummy.getAuthorNames());
        System.out.println("Giá sách: " + javaDummy.getPrice());
        System.out.println("Số lượng: " + javaDummy.getQty());
        javaDummy.setPrice(29.99);
        javaDummy.setQty(50);
        System.out.println("Sau khi cập nhật: " + javaDummy);
    }
}
