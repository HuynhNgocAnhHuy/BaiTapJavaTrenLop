package model;

public class Order {
    private int id;
    private int customerId;

    public Order(int id, int customerId) {
        this.id = id;
        this.customerId = customerId;
    }

    public int getId() { return id; }
    public int getCustomerId() { return customerId; }
}
