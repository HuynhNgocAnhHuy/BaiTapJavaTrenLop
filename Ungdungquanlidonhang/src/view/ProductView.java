package view;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import model.Product;
import java.util.List;

public class ProductView {
    private ListView<String> productListView = new ListView<>();
    private Button addProductButton = new Button("Thêm sản phẩm");
    private VBox layout;

    public ProductView() {
        Label label = new Label("Danh sách sản phẩm:");
        layout = new VBox(10, label, productListView, addProductButton);
    }

    public VBox getLayout() {
        return layout;
    }

    public ListView<String> getProductListView() {
        return productListView;
    }

    public Button getAddProductButton() {
        return addProductButton;
    }

    public void updateProductList(List<Product> products) {
        productListView.getItems().clear();
        for (Product p : products) {
            productListView.getItems().add(p.toString());
        }
    }
}
