package org.example.hastane.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hasta {
    public Hasta (){

    }
    public boolean login(String tc, String sifre) {
        Database db = new Database();
        Connection connection = db.getConnection();

        String stmt = "SELECT * FROM patients WHERE tc = ? AND sifre = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(stmt);
            preparedStatement.setString(1, tc);
            preparedStatement.setString(2, sifre);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.err.println("Giriş hatası: " + e.getMessage());
        }

        return false;
    }
    public org.example.hastane.models.Hasta getPatient(String tc) {
        Database db = new Database();
        Connection connection = db.getConnection();

        String stmt = "SELECT * FROM patients WHERE tc = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(stmt);
            preparedStatement.setString(1, tc);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new org.example.hastane.models.Hasta(
                        resultSet.getString("tc"),
                        resultSet.getString("ad"),
                        resultSet.getString("soyad"),
                        resultSet.getString("cinsiyet"),
                        resultSet.getString("dogum_tarihi"),
                        resultSet.getString("telefon"),
                        resultSet.getString("email"),
                        resultSet.getString("sifre"),
                        resultSet.getString("hesap_acilis_tarihi"),
                        resultSet.getString("hesap_guncelleme_tarihi")
                );
            }
        } catch (SQLException e) {
            System.err.println("Hasta getirme hatası: " + e.getMessage());
        }

        return null;
    }
}
