package DAO;

import model.DatabaseConnection;
import model.Order;
import model.OrderItem;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public void createOrder(int customerId, List<OrderItem> items) {
        String sqlOrder = "INSERT INTO orders (customer_id) VALUES (?)";
        String sqlItem  = "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmtOrder = conn.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmtItem  = conn.prepareStatement(sqlItem)) {

            conn.setAutoCommit(false);

            // Tạo order
            stmtOrder.setInt(1, customerId);
            stmtOrder.executeUpdate();

            // Lấy ID order vừa tạo
            ResultSet rs = stmtOrder.getGeneratedKeys();
            int orderId = -1;
            if (rs.next()) {
                orderId = rs.getInt(1);
            }

            // Thêm các order_items
            for (OrderItem it : items) {
                stmtItem.setInt(1, orderId);
                stmtItem.setInt(2, it.getProductId());
                stmtItem.setInt(3, it.getQuantity());
                stmtItem.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lấy lịch sử đơn hàng của một khách hàng.
     * Kết quả: Mỗi đơn hàng + tổng tiền.
     */
    public List<String> getOrderHistory(int customerId) {
        List<String> history = new ArrayList<>();
        String sql = """
            SELECT o.id AS order_id,
                   SUM(p.price * oi.quantity) AS total_price
            FROM orders o
            JOIN order_items oi ON o.id = oi.order_id
            JOIN products p ON oi.product_id = p.id
            WHERE o.customer_id = ?
            GROUP BY o.id
            """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                double total = rs.getDouble("total_price");
                history.add("Order " + orderId + " - Total: " + total);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return history;
    }
}
