package Bai7_1;

public class DiscountRate {
	 private static final double SERVICE_DISCOUNT_PREMIUM = 0.2;
	    private static final double SERVICE_DISCOUNT_GOLD = 0.15;
	    private static final double SERVICE_DISCOUNT_SILVER = 0.1;

	    private static final double PRODUCT_DISCOUNT_PREMIUM = 0.1;
	    private static final double PRODUCT_DISCOUNT_GOLD = 0.1;
	    private static final double PRODUCT_DISCOUNT_SILVER = 0.1;

	    public static double getServiceDiscountRate(String type) {
	        if (type == null) return 0.0;  // Tránh lỗi null
	        switch (type.toLowerCase()) {
	            case "premium": return SERVICE_DISCOUNT_PREMIUM;
	            case "gold": return SERVICE_DISCOUNT_GOLD;
	            case "silver": return SERVICE_DISCOUNT_SILVER;
	            default: return 0.0;
	        }
	    }

	    public static double getProductDiscountRate(String type) {
	        if (type == null) return 0.0;  // Tránh lỗi null
	        switch (type.toLowerCase()) {
	            case "premium": return PRODUCT_DISCOUNT_PREMIUM;
	            case "gold": return PRODUCT_DISCOUNT_GOLD;
	            case "silver": return PRODUCT_DISCOUNT_SILVER;
	            default: return 0.0;
	        }
	    }
}
