package Bai2;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class EncryptView {
    private VBox view;
    private TextArea inputArea;
    private TextArea outputArea;
    private Button encryptBtn, decryptBtn;
    private ComboBox<String> algorithmBox;
    private Encryptable encryptor;

    public EncryptView() {
        view = new VBox(10);
        view.setPadding(new Insets(20));

        inputArea = new TextArea();
        inputArea.setPromptText("Nhập chuỗi cần mã hóa...");
        outputArea = new TextArea();
        outputArea.setEditable(false);

        algorithmBox = new ComboBox<>();
        algorithmBox.getItems().addAll("AES", "RSA");
        algorithmBox.setValue("AES");

        encryptBtn = new Button("Encrypt");
        decryptBtn = new Button("Decrypt");

        view.getChildren().addAll(
                new Label("Chọn thuật toán:"), algorithmBox,
                new Label("Input:"), inputArea,
                encryptBtn, decryptBtn,
                new Label("Output:"), outputArea
        );


        algorithmBox.setOnAction(e -> updateEncryptor());
        encryptBtn.setOnAction(e -> encryptText());
        decryptBtn.setOnAction(e -> decryptText());

        updateEncryptor();
    }

    private void updateEncryptor() {
        String algo = algorithmBox.getValue();
        encryptor = algo.equals("AES") ? new AESEncryptor() : new RSAEncryptor();
    }

    private void encryptText() {
        String input = inputArea.getText();
        outputArea.setText(encryptor.encrypt(input));
    }

    private void decryptText() {
        String input = outputArea.getText();
        inputArea.setText(encryptor.decrypt(input));
    }

    public VBox getView() {
        return view;
    }
}

