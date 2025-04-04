import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Optional;

public class XMLCrudApp extends Application {
    private static final String XML_FILE_PATH = "data.xml";
    private Document xmlDocument;
    private TreeView<Node> xmlTreeView;

    @Override
    public void start(Stage primaryStage) {
        xmlTreeView = new TreeView<>();
        loadOrCreateXML();
        refreshTreeView();

        Button btnAddChild = new Button("Thêm Con");
        Button btnUpdate = new Button("Cập Nhật");
        Button btnDelete = new Button("Xóa");

        btnAddChild.setOnAction(e -> addChildNode());
        btnUpdate.setOnAction(e -> updateNode());
        btnDelete.setOnAction(e -> deleteNode());

        HBox buttonBar = new HBox(10, btnAddChild, btnUpdate, btnDelete);

        BorderPane mainLayout = new BorderPane();
        mainLayout.setCenter(xmlTreeView);
        mainLayout.setBottom(buttonBar);

        Scene scene = new Scene(mainLayout, 600, 400);
        primaryStage.setTitle("Quản lý XML với JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadOrCreateXML() {
        try {
            File xmlFile = new File(XML_FILE_PATH);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            if (!xmlFile.exists() || xmlFile.length() == 0) {
                createDefaultXML();
            }

            xmlDocument = builder.parse(xmlFile);
            xmlDocument.getDocumentElement().normalize();
        } catch (Exception ex) {
            System.out.println("⚠ Lỗi file XML. Tạo file mới...");
            createDefaultXML();
        }
    }

    private void createDefaultXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            xmlDocument = builder.newDocument();

            Element rootElement = xmlDocument.createElement("root");
            xmlDocument.appendChild(rootElement);

            saveXML();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void saveXML() {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(xmlDocument);
            StreamResult result = new StreamResult(new File(XML_FILE_PATH));
            transformer.transform(source, result);
        } catch (TransformerException ex) {
            ex.printStackTrace();
        }
    }

    private void refreshTreeView() {
        Node rootNode = xmlDocument.getDocumentElement();
        TreeItem<Node> rootItem = createTreeItem(rootNode);
        xmlTreeView.setRoot(rootItem);
        xmlTreeView.setShowRoot(true);
        rootItem.setExpanded(true);
    }

    private TreeItem<Node> createTreeItem(Node node) {
        TreeItem<Node> treeItem = new TreeItem<>(node) {
            @Override
            public String toString() {
                return formatNode(node);
            }
        };
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                treeItem.getChildren().add(createTreeItem(child));
            }
        }
        return treeItem;
    }

    private String formatNode(Node node) {
        String nodeName = node.getNodeName();
        String text = node.getTextContent().trim();
        return text.isEmpty() ? nodeName : nodeName + " : " + text;
    }

    private void addChildNode() {
        TreeItem<Node> selectedItem = xmlTreeView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) return;

        Optional<Pair<String, String>> input = showTagInputDialog("Thêm Node", "Tên thẻ:", "Nội dung:");
        if (input.isPresent()) {
            Pair<String, String> pair = input.get();
            Element newChild = xmlDocument.createElement(pair.getKey());
            newChild.setTextContent(pair.getValue());

            selectedItem.getValue().appendChild(newChild);
            saveXML();
            refreshTreeView();
        }
    }

    private void updateNode() {
        TreeItem<Node> selectedItem = xmlTreeView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) return;
        Node node = selectedItem.getValue();
        if (node.getNodeType() != Node.ELEMENT_NODE) return;

        TextInputDialog dialog = new TextInputDialog(node.getTextContent().trim());
        dialog.setTitle("Cập Nhật Node");
        dialog.setHeaderText("Nhập nội dung mới:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(node::setTextContent);
        saveXML();
        refreshTreeView();
    }

    private void deleteNode() {
        TreeItem<Node> selectedItem = xmlTreeView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) return;
        Node node = selectedItem.getValue();
        if (node.getParentNode() == null) {
            showAlert("Không thể xóa phần tử gốc!");
            return;
        }
        node.getParentNode().removeChild(node);
        saveXML();
        refreshTreeView();
    }

    private Optional<Pair<String, String>> showTagInputDialog(String title, String labelTag, String labelContent) {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle(title);

        TextField tagField = new TextField();
        TextField contentField = new TextField();

        VBox dialogContent = new VBox(10, new Label(labelTag), tagField, new Label(labelContent), contentField);
        dialog.getDialogPane().setContent(dialogContent);

        ButtonType btnOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(btnOK, ButtonType.CANCEL);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == btnOK) {
                return new Pair<>(tagField.getText().trim(), contentField.getText().trim());
            }
            return null;
        });
        return dialog.showAndWait();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, message, ButtonType.OK);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
