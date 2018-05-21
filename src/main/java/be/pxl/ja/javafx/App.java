package be.pxl.ja.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 */
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/window.fxml"));
        Scene scene = new Scene(root, 300,100);
        primaryStage.setTitle("Demo...");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
