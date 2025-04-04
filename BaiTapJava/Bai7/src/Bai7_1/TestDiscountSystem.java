package Bai7_1;
import java.util.Date;
public class TestDiscountSystem {
	public static void main(String[] args) {
        Customer customer1 = new Customer("Alice");
        customer1.setMemberType("Gold");

        Visit visit1 = new Visit(customer1.getName(), new Date());
        visit1.setServiceExpense(100.0);
        visit1.setProductExpense(50.0);

        System.out.println(visit1);

        Customer customer2 = new Customer("Bob");
        customer2.setMemberType("Premium");

        Visit visit2 = new Visit(customer2.getName(), new Date());
        visit2.setServiceExpense(200.0);
        visit2.setProductExpense(100.0);

        System.out.println(visit2);

        Customer customer3 = new Customer("Charlie"); // Không có thành viên
        Visit visit3 = new Visit(customer3.getName(), new Date());
        visit3.setServiceExpense(150.0);
        visit3.setProductExpense(75.0);

        System.out.println(visit3);
    }
}
