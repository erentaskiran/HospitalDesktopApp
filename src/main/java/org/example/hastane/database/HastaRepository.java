package org.example.hastane.database;

import org.example.hastane.models.Hasta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HastaRepository {
    private final Database db;

    public HastaRepository() {
       this.db = Database.getInstance();
    }

    public boolean login(String tc, String sifre) {
        String stmt = "SELECT * FROM patients WHERE tc = ? AND password = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(stmt)) {

            preparedStatement.setString(1, tc);
            preparedStatement.setString(2, sifre);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            System.err.println("Giriş hatası: " + e.getMessage());
        }
        return false;
    }

    public boolean register(Hasta hasta) {
        String stmt = "INSERT INTO patients (tc, first_name, last_name, cinsiyet, dogum_tarihi, telefon, email, password, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(stmt)) {

            preparedStatement.setString(1, hasta.getTc());
            preparedStatement.setString(2, hasta.getAd());
            preparedStatement.setString(3, hasta.getSoyad());
            preparedStatement.setString(4, hasta.getCinsiyet());
            preparedStatement.setDate(5, hasta.getDogumTarihi());
            preparedStatement.setString(6, hasta.getTelefon());
            preparedStatement.setString(7, hasta.getEmail());
            preparedStatement.setString(8, hasta.getSifre());
            preparedStatement.setDate(9, hasta.getHesapAcilisTarihi());
            preparedStatement.setDate(10,hasta.getHesapGuncellemeTarihi());

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Kayıt hatası: " + e.getMessage());
            return false;
        }
    }

    public Hasta getPatient(String tc) {
        String stmt = "SELECT * FROM patients WHERE tc = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(stmt)) {

            preparedStatement.setString(1, tc);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Hasta(
                            resultSet.getString("tc"),
                            resultSet.getString("ad"),
                            resultSet.getString("soyad"),
                            resultSet.getString("cinsiyet"),
                            resultSet.getDate("dogum_tarihi").getTime(),
                            resultSet.getString("telefon"),
                            resultSet.getString("email"),
                            resultSet.getString("sifre"),
                            Long.getLong(resultSet.getString("hesap_acilis_tarihi")),
                            Long.getLong(resultSet.getString("hesap_guncelleme_tarihi"))
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Hasta getirme hatası: " + e.getMessage());
        }
        return null;
    }
}