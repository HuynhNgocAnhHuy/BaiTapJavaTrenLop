package controller;

import DAO.CustomerDAO;
import DAO.CustomerDAO;
import javafx.scene.control.TextInputDialog;
import model.Customer;
import view.CustomerView;

import java.util.List;

public class CustomerController {
    private CustomerDAO customerDAO;
    private CustomerView customerView;

    public CustomerController(CustomerDAO dao, CustomerView view) {
        this.customerDAO = dao;
        this.customerView = view;
        updateView();

        // Thêm khách hàng
        customerView.getAddCustomerButton().setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Thêm khách hàng");
            dialog.setHeaderText(null);
            dialog.setContentText("Nhập tên khách hàng:");
            dialog.showAndWait().ifPresent(name -> {
                customerDAO.addCustomer(name);
                updateView();
            });
        });
    }

    private void updateView() {
        List<Customer> customers = customerDAO.getAllCustomers();
        customerView.updateCustomerList(customers);
    }
}
