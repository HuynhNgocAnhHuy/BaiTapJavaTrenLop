import DAO.OrderDAO;
import controller.*;
import DAO.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import view.*;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Tạo DAO
        CustomerDAO customerDAO = new CustomerDAO();
        ProductDAO productDAO = new ProductDAO();
        OrderDAO orderDAO = new OrderDAO();

        // Tạo View
        CustomerView customerView = new CustomerView();
        ProductView productView   = new ProductView();
        OrderView orderView       = new OrderView();

        // Tạo Controller
        new CustomerController(customerDAO, customerView);
        new ProductController(productDAO, productView);
        new OrderController(orderDAO, customerDAO, productDAO, orderView);

        // Tạo TabPane
        TabPane tabPane = new TabPane();

        Tab tabCustomer = new Tab("Khách hàng", customerView.getLayout());
        Tab tabProduct  = new Tab("Sản phẩm", productView.getLayout());
        Tab tabOrder    = new Tab("Đơn hàng", orderView.getLayout());

        tabPane.getTabs().addAll(tabCustomer, tabProduct, tabOrder);

        Scene scene = new Scene(tabPane, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Quản lý đơn hàng (Order Management)");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
