import java.util.Objects;

class Product {
    private String name;
    private String category;
    private double price;

public Product(String name, String category, double price) {
    this.name = name;
    this.category = category;
    this.price = price;
}

public String getName() {
    return name;
}

public String getCategory() {
    return category;
}

public double getPrice() {
    return price;
}

public void setPrice(double price) {
    this.price = price;
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return Objects.equals(name, product.name) && Objects.equals(category, product.category);
}

@Override
public int hashCode() {
    return Objects.hash(name, category);
}

@Override
public String toString() {
    return "Product{" +
            "name='" + name + '\'' +
            ", category='" + category + '\'' +
            ", price=" + price +
            '}';
}
}