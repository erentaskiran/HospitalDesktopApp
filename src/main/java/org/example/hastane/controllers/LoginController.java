package org.example.hastane.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import org.example.hastane.database.DoktorRepository;
import org.example.hastane.database.HastaRepository;
import org.example.hastane.utils.PasswordHasher;

import java.io.File;
import java.io.IOException;

public class LoginController {
    @FXML
    private TextField tcLogin;
    @FXML
    private PasswordField passwordLogin;
    @FXML
    private ChoiceBox roleLogin;

    @FXML
    public void onLoginClicked() {
        String email = tcLogin.getText();
        String password = passwordLogin.getText();
        String role = roleLogin.getValue().toString();

        PasswordHasher hasher = new PasswordHasher();
        String pwd = hasher.hashPassword(password);


        if (role.equals("Hasta")) {
            HastaRepository hastaRepository = new HastaRepository();
            boolean isLoggedIn = hastaRepository.login(email, pwd);
            if (isLoggedIn) {
                System.out.println("Giriş başarılı!");
            } else {
                System.out.println("Giriş başarısız!");
            }
        } else if (role.equals("Doktor")) {
            DoktorRepository doktorRepository = new DoktorRepository();
            boolean isLoggedIn = doktorRepository.login(email, pwd);
            if (isLoggedIn) {
                System.out.println("Giriş başarılı!");
            } else {
                System.out.println("Giriş başarısız!");
            }
        }
    }

    @FXML
    public void onRegisterClicked() throws IOException {
        try {
            File xmlFile = new File("src/main/java/org/example/hastane/views/register.fxml");
            if (!xmlFile.exists()) {
                System.err.println("FXML dosyası bulunamadı: " + xmlFile.getAbsolutePath());
                return;
            }

            FXMLLoader fxmlLoader = new FXMLLoader(xmlFile.toURI().toURL());
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root, 1920, 1080);

            Stage currentStage = (Stage) tcLogin.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
