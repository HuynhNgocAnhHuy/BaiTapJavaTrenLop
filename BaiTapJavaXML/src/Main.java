import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Main extends Application {
    private TableView<Item> table = new TableView<>();
    private ObservableList<Item> dataList = FXCollections.observableArrayList();
    private File xmlFile = new File("data.xml");
    private TextField idField = new TextField();
    private TextField nameField = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TableColumn<Item, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(cellData -> cellData.getValue().idProperty());

        TableColumn<Item, String> nameCol = new TableColumn<>("Tên");
        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        table.getColumns().addAll(idCol, nameCol);
        loadXMLData();

        idField.setPromptText("ID");
        nameField.setPromptText("Tên");

        Button addButton = new Button("Thêm");
        addButton.setOnAction(e -> {
            addItem(idField.getText(), nameField.getText());
            idField.clear();
            nameField.clear();
        });

        Button updateButton = new Button("Sửa");
        updateButton.setOnAction(e -> {
            Item selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                updateItem(selected.getId(), idField.getText(), nameField.getText());
            }
        });

        Button deleteButton = new Button("Xóa");
        deleteButton.setOnAction(e -> {
            Item selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                deleteItem(selected.getId());
            }
        });

        // Khi chọn một hàng, hiển thị dữ liệu lên ô nhập
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                idField.setText(newSelection.getId());
                nameField.setText(newSelection.getName());
            }
        });

        VBox vbox = new VBox(10, table, idField, nameField, addButton, updateButton, deleteButton);
        Scene scene = new Scene(vbox, 400, 450);

        primaryStage.setTitle("CRUD XML với JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadXMLData() {
        dataList.clear();
        if (!xmlFile.exists()) return;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("item");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String id = element.getElementsByTagName("id").item(0).getTextContent();
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    dataList.add(new Item(id, name));
                }
            }
            table.setItems(dataList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addItem(String id, String name) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc;
            Element root;

            if (xmlFile.exists()) {
                doc = builder.parse(xmlFile);
                root = doc.getDocumentElement();
            } else {
                doc = builder.newDocument();
                root = doc.createElement("items");
                doc.appendChild(root);
            }

            Element newItem = doc.createElement("item");
            Element idElement = doc.createElement("id");
            idElement.appendChild(doc.createTextNode(id));
            Element nameElement = doc.createElement("name");
            nameElement.appendChild(doc.createTextNode(name));

            newItem.appendChild(idElement);
            newItem.appendChild(nameElement);
            root.appendChild(newItem);

            saveXML(doc);
            loadXMLData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateItem(String oldId, String newId, String newName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            NodeList nodeList = doc.getElementsByTagName("item");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    if (element.getElementsByTagName("id").item(0).getTextContent().equals(oldId)) {
                        element.getElementsByTagName("id").item(0).setTextContent(newId);
                        element.getElementsByTagName("name").item(0).setTextContent(newName);
                        break;
                    }
                }
            }

            saveXML(doc);
            loadXMLData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteItem(String id) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            NodeList nodeList = doc.getElementsByTagName("item");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    if (element.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
                        element.getParentNode().removeChild(element);
                        break;
                    }
                }
            }

            saveXML(doc);
            loadXMLData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveXML(Document doc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(xmlFile);
        transformer.transform(source, result);
    }
}
