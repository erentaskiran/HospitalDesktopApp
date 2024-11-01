package org.example.hastane.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/";

    private Connection connection;

    public void connect(String database, String user, String password) {
        try {
            connection = DriverManager.getConnection(URL+database, user, password);
            System.out.println("Bağlantı başarılı!");
        } catch (SQLException e) {
            System.err.println("Bağlantı hatası: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Bağlantı kapatıldı.");
            }
        } catch (SQLException e) {
            System.err.println("Bağlantı kapatma hatası: " + e.getMessage());
        }
    }
}
