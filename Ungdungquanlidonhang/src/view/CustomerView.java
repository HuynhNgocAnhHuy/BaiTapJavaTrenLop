package view;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import model.Customer;
import java.util.List;

public class CustomerView {
    private ListView<String> customerListView = new ListView<>();
    private Button addCustomerButton = new Button("Thêm khách hàng");
    private VBox layout;

    public CustomerView() {
        Label label = new Label("Danh sách khách hàng:");
        layout = new VBox(10, label, customerListView, addCustomerButton);
    }

    public VBox getLayout() {
        return layout;
    }

    public ListView<String> getCustomerListView() {
        return customerListView;
    }

    public Button getAddCustomerButton() {
        return addCustomerButton;
    }

    public void updateCustomerList(List<Customer> customers) {
        customerListView.getItems().clear();
        for (Customer c : customers) {
            customerListView.getItems().add(c.toString());
        }
    }
}
