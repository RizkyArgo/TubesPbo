package fotokopiku;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Transaksi {

    // ===== ATTRIBUTE =====
    private int idTransaksi;
    private String namaPelanggan;
    private String tipeLayanan;
    private int jumlahLembar;
    private BigDecimal totalHarga;

    // ===== CONSTRUCTOR =====
    public Transaksi(String namaPelanggan, String tipeLayanan, int jumlahLembar, BigDecimal totalHarga) {
        this.namaPelanggan = namaPelanggan;
        this.tipeLayanan = tipeLayanan;
        this.jumlahLembar = jumlahLembar;
        this.totalHarga = totalHarga;
    }

    // ===== SIMPAN TRANSAKSI =====
    public void simpan(int idOperator) {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "INSERT INTO transaksi (nama_pelanggan, tipe_layanan, jumlah_lembar, total_harga, id_user) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, namaPelanggan);
            ps.setString(2, tipeLayanan);
            ps.setInt(3, jumlahLembar);
            ps.setBigDecimal(4, totalHarga);
            ps.setInt(5, idOperator);

            ps.executeUpdate();
            System.out.println("Transaksi berhasil disimpan!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ===== TAMPIL RIWAYAT TRANSAKSI =====
    public static void infoDB() {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "SELECT * FROM transaksi";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("=== RIWAYAT TRANSAKSI ===");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id_transaksi") + " | " +
                    rs.getString("nama_pelanggan") + " | " +
                    rs.getString("tipe_layanan") + " | " +
                    rs.getInt("jumlah_lembar") + " | Rp " +
                    rs.getBigDecimal("total_harga")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ===== TOTAL PENDAPATAN =====
    public static BigDecimal totalPendapatan() {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "SELECT SUM(total_harga) AS total FROM transaksi";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getBigDecimal("total");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return BigDecimal.ZERO;
    }
}
