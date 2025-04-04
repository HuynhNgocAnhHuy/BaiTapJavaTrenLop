package Bai7_1;
import java.util.Date;
public class Visit {
	 private Customer customer;
	    private Date date;
	    private double serviceExpense;
	    private double productExpense;

	    public Visit(String customerName, Date date) {
	        this.customer = new Customer(customerName);
	        this.date = date;
	    }

	    public String getName() {
	        return customer.getName();
	    }

	    public double getServiceExpense() {
	        return serviceExpense;
	    }

	    public void setServiceExpense(double expense) {
	        this.serviceExpense = expense;
	    }

	    public double getProductExpense() {
	        return productExpense;
	    }

	    public void setProductExpense(double expense) {
	        this.productExpense = expense;
	    }

	    public double getTotalExpense() {
	        String memberType = customer.getMemberType();
	        double serviceDiscount = DiscountRate.getServiceDiscountRate(memberType);
	        double productDiscount = DiscountRate.getProductDiscountRate(memberType);

	        double totalServiceCost = serviceExpense * (1 - serviceDiscount);
	        double totalProductCost = productExpense * (1 - productDiscount);

	        return totalServiceCost + totalProductCost;
	    }

	    @Override
	    public String toString() {
	        return "Visit{customer=" + customer + ", date=" + date + ", serviceExpense=" + serviceExpense + ", productExpense=" + productExpense + ", totalExpense=" + getTotalExpense() + "}";
	    }
}
