package controller;

import DAO.ProductDAO;
import DAO.ProductDAO;
import javafx.scene.control.TextInputDialog;
import model.Product;
import view.ProductView;

import java.util.List;

public class ProductController {
    private ProductDAO productDAO;
    private ProductView productView;

    public ProductController(ProductDAO dao, ProductView view) {
        this.productDAO = dao;
        this.productView = view;
        updateView();

        // Thêm sản phẩm
        productView.getAddProductButton().setOnAction(e -> {
            TextInputDialog dialogName = new TextInputDialog();
            dialogName.setTitle("Thêm sản phẩm");
            dialogName.setHeaderText(null);
            dialogName.setContentText("Nhập tên sản phẩm:");

            TextInputDialog dialogPrice = new TextInputDialog();
            dialogPrice.setTitle("Thêm sản phẩm");
            dialogPrice.setHeaderText(null);
            dialogPrice.setContentText("Nhập giá sản phẩm (VD: 150.0):");

            dialogName.showAndWait().ifPresent(productName -> {
                dialogPrice.showAndWait().ifPresent(strPrice -> {
                    try {
                        double price = Double.parseDouble(strPrice);
                        productDAO.addProduct(productName, price);
                        updateView();
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                    }
                });
            });
        });
    }

    private void updateView() {
        List<Product> products = productDAO.getAllProducts();
        productView.updateProductList(products);
    }
}
