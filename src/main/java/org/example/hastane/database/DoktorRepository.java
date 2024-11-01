package org.example.hastane.database;

import org.example.hastane.models.Doktor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoktorRepository {
    private final Database db;

    public DoktorRepository() {
        this.db = Database.getInstance();
    }

    public boolean login(String tc, String sifre) {
        String stmt = "SELECT * FROM doctors WHERE tc = ? AND password = ?";
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

    public boolean register(Doktor doktor) {
        String stmt = "INSERT INTO doctors (tc, first_name, last_name, cinsiyet, dogum_tarihi, telefon, email, password, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(stmt)) {

            preparedStatement.setString(1, doktor.getTc());
            preparedStatement.setString(2, doktor.getAd());
            preparedStatement.setString(3, doktor.getSoyad());
            preparedStatement.setString(4, doktor.getCinsiyet());
            preparedStatement.setDate(5, doktor.getDogumTarihi());
            preparedStatement.setString(6, doktor.getTelefon());
            preparedStatement.setString(7, doktor.getEmail());
            preparedStatement.setString(8, doktor.getSifre());
            preparedStatement.setDate(9, doktor.getHesapAcilisTarihi());
            preparedStatement.setDate(10,doktor.getHesapGuncellemeTarihi());

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Kayıt hatası: " + e.getMessage());
            return false;
        }
    }

    public Doktor getDoctor(String tc) {
        String stmt = "SELECT * FROM doctors WHERE tc = ?";
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(stmt)) {

            preparedStatement.setString(1, tc);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Doktor(
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
