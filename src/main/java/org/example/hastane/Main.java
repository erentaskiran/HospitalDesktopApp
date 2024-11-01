package org.example.hastane;
import io.github.cdimascio.dotenv.Dotenv;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.hastane.database.Database;

import java.io.File;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Dotenv dotenv = Dotenv.load();

        String dbname = dotenv.get("DB_NAME");
        String dbusername = dotenv.get("DB_USERNAME");
        String dbpassword = dotenv.get("DB_PASSWORD");

        // Database connection
        Database db = new Database();
        db.connect(dbname, dbusername, dbpassword);

        // Load login.fxml
        File xmlfile = new File("src/main/java/org/example/hastane/views/login.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(xmlfile.toURI().toURL());

        Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}