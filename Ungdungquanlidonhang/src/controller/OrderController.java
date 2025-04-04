package controller;

import DAO.*;
import DAO.CustomerDAO;
import DAO.OrderDAO;
import DAO.ProductDAO;
import javafx.scene.control.Alert;
import model.*;
import view.OrderView;

import java.util.ArrayList;
import java.util.List;

public class OrderController {
    private OrderDAO orderDAO;
    private CustomerDAO customerDAO;
    private ProductDAO productDAO;
    private OrderView orderView;

    public OrderController(OrderDAO orderDAO, CustomerDAO customerDAO,
                           ProductDAO productDAO, OrderView orderView) {
        this.orderDAO = orderDAO;
        this.customerDAO = customerDAO;
        this.productDAO = productDAO;
        this.orderView = orderView;

        initData();
        initEvents();
    }

    private void initData() {
        // Cập nhật danh sách khách hàng cho ComboBox
        orderView.updateCustomerCombo(customerDAO.getAllCustomers());
        // Cập nhật danh sách sản phẩm
        orderView.updateProductList(productDAO.getAllProducts());
    }

    private void initEvents() {
        // Tạo đơn hàng
        orderView.getCreateOrderButton().setOnAction(e -> {
            Customer selectedCustomer = orderView.getCustomerComboBox()
                    .getSelectionModel().getSelectedItem();
            List<Product> selectedProducts = orderView.getProductListView()
                    .getSelectionModel()
                    .getSelectedItems();
            if (selectedCustomer == null || selectedProducts.isEmpty()) {
                showAlert("Thông báo", "Hãy chọn khách hàng và ít nhất một sản phẩm!");
                return;
            }

            // Mặc định quantity = 1 cho mỗi sản phẩm được chọn
            List<OrderItem> items = new ArrayList<>();
            for (Product p : selectedProducts) {
                items.add(new OrderItem(0, 0, p.getId(), 1));
            }

            // Tạo đơn hàng
            orderDAO.createOrder(selectedCustomer.getId(), items);

            showAlert("Thành công", "Đơn hàng đã được tạo!");

            // Cập nhật lịch sử đơn hàng của khách hàng
            loadOrderHistory(selectedCustomer.getId());
        });

        // Sự kiện thay đổi khách hàng -> cập nhật lịch sử
        orderView.getCustomerComboBox().setOnAction(e -> {
            Customer c = orderView.getCustomerComboBox().getSelectionModel().getSelectedItem();
            if (c != null) {
                loadOrderHistory(c.getId());
            }
        });
    }

    private void loadOrderHistory(int customerId) {
        List<String> history = orderDAO.getOrderHistory(customerId);
        orderView.updateHistoryList(history);
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
