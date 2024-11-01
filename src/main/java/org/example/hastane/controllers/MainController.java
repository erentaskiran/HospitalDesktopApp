package org.example.hastane.controllers;

import com.sun.tools.javac.Main;
import javafx.fxml.FXMLLoader;

public class MainController {

    public  void onHastaClicked() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/org/example/hastane/views/login.fxml"));
        try {
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void onDoktorClicked() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/org/example/hastane/views/login.fxml"));
        try {
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
