package tokoalatkesehatan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
    private Connection koneksi;

    public Connection conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/alat_kesehatan"; // Sesuaikan dengan nama database Anda
            this.koneksi = DriverManager.getConnection(url, "root", ""); // Sesuaikan username dan password Anda
            System.out.println("Koneksi Database Berhasil");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Koneksi Database Gagal: " + ex.getMessage());
        }
        return this.koneksi;
    }

    public void disconnect() {
        try {
            if (this.koneksi != null) {
                this.koneksi.close();
                System.out.println("Koneksi Database Ditutup");
            }
        } catch (SQLException ex) {
            System.out.println("Gagal menutup koneksi: " + ex.getMessage());
        }
    }
}