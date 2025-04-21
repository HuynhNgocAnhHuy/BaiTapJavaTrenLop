package Bai1;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        LoginView loginView = new LoginView();
        primaryStage.setScene(new Scene(loginView.getView()));
        primaryStage.setTitle("Login System");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
