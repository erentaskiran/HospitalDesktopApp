package org.example.hastane.database;

import io.github.cdimascio.dotenv.Dotenv;
import org.postgresql.util.JdbcBlackHole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database instance;
    private Connection connection;
    private String dbname;
    private String dbusername;
    private String dbpassword;
    private String dbhost;
    private String dbport;

    // Private constructor to prevent instantiation
    private Database() {
        try {
            Dotenv dotenv = Dotenv.load();
            dbname = dotenv.get("DB_NAME");
            dbusername = dotenv.get("DB_USERNAME");
            dbpassword = dotenv.get("DB_PASSWORD");
            dbhost = dotenv.get("DB_HOST");
            dbport = dotenv.get("DB_PORT");

            connection = DriverManager.getConnection("jdbc:postgresql://" + dbhost + ":" + dbport + "/" + dbname, dbusername, dbpassword);
            System.out.println("Database connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}