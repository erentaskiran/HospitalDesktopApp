package org.example.hastane.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import org.example.hastane.database.Database;
import org.example.hastane.database.Hasta;
import org.example.hastane.utils.PasswordHasher;

import java.sql.Connection;

public class LoginController {
    @FXML
    private TextField tcLogin;
    @FXML
    private PasswordField passwordLogin;
    @FXML
    private ChoiceBox roleLogin;

    @FXML
    public void onLoginClicked() {
        Database db = new Database();

        String email = tcLogin.getText();
        String password = passwordLogin.getText();
        String role = roleLogin.getValue().toString();

        PasswordHasher hasher = new PasswordHasher();
        password = hasher.hashPassword(password);


        if (role.equals("Hasta")) {
            Hasta hasta = new Hasta();
            boolean isLoggedIn = hasta.login(email, password);
            if (isLoggedIn) {
                System.out.println("Giriş başarılı!");
            } else {
                System.out.println("Giriş başarısız!");
            }
        }
    }
}
