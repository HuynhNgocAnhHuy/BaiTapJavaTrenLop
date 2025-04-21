package Bai2;

import Bai1.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage primaryStage) {
        EncryptView view = new EncryptView();
        primaryStage.setScene(new Scene(view.getView()));
        primaryStage.setTitle("Encryption Demo");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

