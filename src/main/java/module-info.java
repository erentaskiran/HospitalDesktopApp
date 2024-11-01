module org.example.hastane {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires jdk.compiler;
    requires java.sql;
    requires io.github.cdimascio.dotenv.java;
    requires org.postgresql.jdbc;


    opens org.example.hastane.controllers to javafx.fxml;

    exports org.example.hastane;
    exports org.example.hastane.controllers;
    exports org.example.hastane.models;
}