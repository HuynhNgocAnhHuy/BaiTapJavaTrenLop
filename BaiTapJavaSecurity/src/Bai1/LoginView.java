package Bai1;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class LoginView {
    private VBox view;
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private Label statusLabel;

    public LoginView() {
        view = new VBox(10);
        view.setPadding(new Insets(20));

        usernameField = new TextField();
        passwordField = new PasswordField();
        loginButton = new Button("Login");
        statusLabel = new Label();

        view.getChildren().addAll(
                new Label("Username:"), usernameField,
                new Label("Password:"), passwordField,
                loginButton, statusLabel
        );

        loginButton.setOnAction(e -> handleLogin());
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String hash = HashUtil.hashPassword(password);

        if (username.equals("AnhHuy") && hash.equals(HashUtil.hashPassword("123456789"))) {
            statusLabel.setText("Đăng nhập thành công!");
        } else {
            statusLabel.setText("Sai thông tin đăng nhập.");
        }
    }

    public VBox getView() {
        return view;
    }
}

