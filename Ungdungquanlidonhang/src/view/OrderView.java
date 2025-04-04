package view;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import model.Customer;
import model.Product;
import java.util.List;

public class OrderView {
    private ComboBox<Customer> customerComboBox = new ComboBox<>();
    private ListView<Product> productListView = new ListView<>();
    private Button createOrderButton = new Button("Tạo đơn hàng");
    private ListView<String> historyListView = new ListView<>();
    private VBox layout;

    public OrderView() {
        Label label1 = new Label("Chọn khách hàng:");
        Label label2 = new Label("Chọn sản phẩm (multi-select):");
        Label label3 = new Label("Lịch sử đơn hàng:");

        // Cho phép chọn nhiều sản phẩm
        productListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        layout = new VBox(10,
                label1, customerComboBox,
                label2, productListView,
                createOrderButton,
                label3, historyListView
        );
    }

    public VBox getLayout() {
        return layout;
    }

    public ComboBox<Customer> getCustomerComboBox() {
        return customerComboBox;
    }

    public ListView<Product> getProductListView() {
        return productListView;
    }

    public Button getCreateOrderButton() {
        return createOrderButton;
    }

    public ListView<String> getHistoryListView() {
        return historyListView;
    }

    // Cập nhật danh sách khách hàng cho ComboBox
    public void updateCustomerCombo(List<Customer> customers) {
        customerComboBox.setItems(FXCollections.observableArrayList(customers));
        if (!customers.isEmpty()) {
            customerComboBox.getSelectionModel().selectFirst();
        }
    }

    // Cập nhật danh sách sản phẩm cho ListView
    public void updateProductList(List<Product> products) {
        productListView.setItems(FXCollections.observableArrayList(products));
    }

    // Cập nhật lịch sử đơn hàng
    public void updateHistoryList(List<String> history) {
        historyListView.getItems().setAll(history);
    }
}
