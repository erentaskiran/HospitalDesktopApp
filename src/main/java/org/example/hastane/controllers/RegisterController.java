package org.example.hastane.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.hastane.database.DoktorRepository;
import org.example.hastane.database.HastaRepository;
import org.example.hastane.models.Doktor;
import org.example.hastane.models.Hasta;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

public class RegisterController {
    @FXML
    public TextField tcRegister;
    @FXML
    public TextField isimRegister;
    @FXML
    public TextField soyadRegister;
    @FXML
    public ChoiceBox cinsiyetRegister;
    @FXML
    public DatePicker dgRegister;
    @FXML
    public TextField telnoRegister;
    @FXML
    public TextField emailRegister;
    @FXML
    public TextField sifreRegister;
    @FXML
    public ChoiceBox rolRegister;
    public void onRegisterClicked() throws IOException {
        String tc = tcRegister.getText();
        String ad = isimRegister.getText();
        String soyad = soyadRegister.getText();
        String cinsiyet = cinsiyetRegister.getValue().toString();
        Long dogumTarihi = dgRegister.getValue().toEpochDay();
        String telefon = telnoRegister.getText();
        String email = emailRegister.getText();
        String sifre = sifreRegister.getText();
        String role = rolRegister.getValue().toString();

        if (tc.isEmpty() || ad.isEmpty() || soyad.isEmpty() || cinsiyet.isEmpty() || dogumTarihi == null || telefon.isEmpty() || email.isEmpty() || sifre.isEmpty() || role.isEmpty()) {
            System.out.println("Lütfen tüm alanları doldurunuz!");
            return;
        }

        if(cinsiyet.equals("Erkek")) {
            cinsiyet = "E";
        } else {
            cinsiyet = "K";
        }


        Date dt = new Date();

        if (role.equals("Hasta")) {
            Hasta hasta = new Hasta(tc, ad, soyad, cinsiyet, dogumTarihi, telefon, email, sifre, dt.getTime(), dt.getTime());
            HastaRepository hastaRepository = new HastaRepository();
            if (hastaRepository.register(hasta)) {
                System.out.println("Kayıt başarılı!");
                RouteToPage("login");
            } else {
                System.out.println("Kayıt başarısız!");
            }
        } else if (role.equals("Doktor")) {
            Doktor doktor = new Doktor(tc, ad, soyad, cinsiyet, dogumTarihi, telefon, email, sifre, dt.getTime(), dt.getTime());
            DoktorRepository doktorRepository = new DoktorRepository();
            if (doktorRepository.register(doktor)) {
                System.out.println("Kayıt başarılı!");
                RouteToPage("login");
            } else {
                System.out.println("Kayıt başarısız!");
            }
        }
    }

    private void RouteToPage(String page) throws IOException {
        File xmlFile = new File("src/main/java/org/example/hastane/views/"+page+".fxml");
        if (!xmlFile.exists()) {
            System.err.println("FXML dosyası bulunamadı: " + xmlFile.getAbsolutePath());
            return;
        }

        FXMLLoader fxmlLoader = new FXMLLoader(xmlFile.toURI().toURL());
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 1920, 1080);

        Stage currentStage = (Stage) tcRegister.getScene().getWindow();
        currentStage.setScene(scene);
    }
}
