package Bai2_4;

public class TestMain {
	 public static void main(String[] args) {
	        Customer c1 = new Customer(88, "Tan Ah Teck", 10);
	        System.out.println(c1);

	        c1.setDiscount(8);
	        System.out.println(c1);
	        System.out.println("id là: " + c1.getId());
	        System.out.println("tên là: " + c1.getName());
	        System.out.println("giảm giá là: " + c1.getDiscount());

	        Invoice inv1 = new Invoice(101, c1, 888.8);
	        System.out.println(inv1);

	        inv1.setAmount(999.9);
	        System.out.println(inv1);
	        System.out.println("id là: " + inv1.getId());
	        System.out.println("khách hàng là: " + inv1.getCustomer());
	        System.out.println("số tiền là: " + inv1.getAmount());
	        System.out.println("Mã số khách hàng là: " + inv1.getCustomerId());
	        System.out.println("tên khách hàng là: " + inv1.getCustomerName());
	        System.out.println("giảm giá của khách hàng là: " + inv1.getCustomerDiscount());
	        System.out.printf("số tiền sau khi giảm giá là: %.2f%n", inv1.getAmountAfterDiscount());
	    }
}
