package fotokopiku;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Layanan {

    // ===== ATTRIBUTE (CLASS DIAGRAM) =====
    private int idLayanan;
    private String namaLayanan;
    private BigDecimal hargaPerHalaman;
    private String tipe;

    // ===== CONSTRUCTOR =====
    public Layanan(int idLayanan, String namaLayanan, BigDecimal hargaPerHalaman, String tipe) {
        this.idLayanan = idLayanan;
        this.namaLayanan = namaLayanan;
        this.hargaPerHalaman = hargaPerHalaman;
        this.tipe = tipe;
    }

    // ===== LOGIC OOP =====
    public BigDecimal cekHarga(int jumlah) {
        return hargaPerHalaman.multiply(BigDecimal.valueOf(jumlah));
    }

    public int getId() {
        return idLayanan;
    }

    public String getNama() {
        return namaLayanan;
    }

    public BigDecimal getHargaPerHalaman() {
        return hargaPerHalaman;
    }

    public String getTipe() {
        return tipe;
    }

    public void info() {
        System.out.println("Nama Layanan : " + namaLayanan);
        System.out.println("Harga/Halaman: " + hargaPerHalaman);
        System.out.println("Tipe         : " + tipe);
    }

    // ===== DATABASE =====
    public static void infoDB() {
        try {
            Connection conn = Koneksi.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM layanan");

            System.out.println("=== DATA LAYANAN ===");
            while (rs.next()) {
                System.out.println(
                    "ID      : " + rs.getInt("id_layanan") +
                    "\nNama    : " + rs.getString("nama_layanan") +
                    "\nHarga   : " + rs.getBigDecimal("harga_per_lembar") +
                    "\nTipe    : " + rs.getString("tipe_layanan") +
                    "\n----------------------"
                );
            }

        } catch (Exception e) {
            System.out.println("Gagal mengambil data layanan");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ID: " + idLayanan +
               " | Nama: " + namaLayanan +
               " | Harga: " + hargaPerHalaman;
    }
}
