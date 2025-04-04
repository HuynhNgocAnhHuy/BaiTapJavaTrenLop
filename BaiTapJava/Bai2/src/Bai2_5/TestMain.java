package Bai2_5;

public class TestMain {
	 public static void main(String[] args) {
	        Customer c1 = new Customer(88, "Tan Ah Teck", 'm');
	        System.out.println(c1);

	        Account acc1 = new Account(101, c1);
	        System.out.println(acc1);

	        acc1.deposit(100.50);
	        System.out.println("After deposit: " + acc1);

	        acc1.withdraw(50.25);
	        System.out.println("After withdrawal: " + acc1);

	        acc1.withdraw(100.00);
	        System.out.println("After attempted over-withdrawal: " + acc1);

	        System.out.println("Customer name: " + acc1.getCustomerName());
	    }
}
