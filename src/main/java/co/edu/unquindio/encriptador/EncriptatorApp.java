package co.edu.unquindio.encriptador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EncriptatorApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EncriptatorApp.class.getResource("view/principal-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Encriptador de texto");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}