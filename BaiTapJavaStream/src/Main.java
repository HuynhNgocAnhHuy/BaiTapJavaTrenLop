import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Customer c1 = new Customer(2);
        Customer c2 = new Customer(1);

        Product p1 = new Product("Toy Car", "Toys", 100);
        Product p2 = new Product("Doll", "Toys", 80);
        Product p3 = new Product("Laptop", "Electronics", 1000);

        Order o1 = new Order(LocalDate.of(2021, 2, 15), LocalDate.of(2021, 2, 20), "Delivered", c1, Arrays.asList(p1, p3));
        Order o2 = new Order(LocalDate.of(2021, 3, 5), LocalDate.of(2021, 3, 10), "Delivered", c2, Collections.singletonList(p2));
        Order o3 = new Order(LocalDate.of(2021, 2, 25), LocalDate.of(2021, 3, 1), "Delivered", c1, Arrays.asList(p2, p3));

        List<Order> orders = Arrays.asList(o1, o2, o3);

        List<Product> discountedProducts = orders.stream()
                .filter(order -> order.getCustomer().getTier() == 2)
                .filter(order -> !order.getOrderDate().isBefore(LocalDate.of(2021, 2, 1))
                        && !order.getOrderDate().isAfter(LocalDate.of(2021, 4, 1)))
                .flatMap(order -> order.getProducts().stream())
                .peek(product -> System.out.println("Processing product: " + product))
                .map(product -> {
                    if ("Toys".equalsIgnoreCase(product.getCategory())) {
                        return new Product(product.getName(), product.getCategory(), product.getPrice() * 0.9);
                    }
                    return product;
                })
                .distinct()
                .collect(Collectors.toList());

        System.out.println("\nDiscounted Products:");
        discountedProducts.forEach(System.out::println);
    }
}