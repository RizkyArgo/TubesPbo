package fotokopiku;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Operator extends User implements Cetak {

    private Layanan layanan;
    private Transaksi transaksi;
    Scanner s = new Scanner(System.in);

    public Operator(int idUser, String username, String password) {
        super(idUser, username, password, "operator");
    }

    @Override
    public boolean login() {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "SELECT * FROM user WHERE username=? AND password=? AND role='operator'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                this.idUser = rs.getInt("id_user");
                System.out.println("Login Operator berhasil!");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Login Operator gagal!");
        return false;
    }

    // ==============================
    // INPUT TRANSAKSI (TUGAS UTAMA)
    // ==============================
    public void inputTransaksi() {
    try {
        // ===== INPUT DARI OPERATOR =====
        System.out.print("Masukkan Nama Pelanggan: ");
        String namaPelanggan = s.next();

        System.out.print("Masukkan ID Layanan: ");
        int idLayanan = s.nextInt();

        System.out.print("Masukkan Jumlah Lembar: ");
        int jumlah = s.nextInt();

        Connection conn = Koneksi.getConnection();

        // ===== AMBIL DATA LAYANAN =====
        String sqlLayanan = "SELECT * FROM layanan WHERE id_layanan = ?";
        PreparedStatement psl = conn.prepareStatement(sqlLayanan);
        psl.setInt(1, idLayanan);
        ResultSet rs = psl.executeQuery();

        if (!rs.next()) {
            System.out.println("Layanan tidak ditemukan!");
            return;
        }

        // ===== DEKLARASI VARIABEL (INI KUNCI) =====
        String tipeLayanan = rs.getString("tipe");
        BigDecimal hargaPerHalaman = rs.getBigDecimal("harga_per_halaman");

        BigDecimal totalHarga = hargaPerHalaman.multiply(
                BigDecimal.valueOf(jumlah)
        );

        // ===== BUAT OBJEK TRANSAKSI =====
        Transaksi transaksi = new Transaksi(
                namaPelanggan,
                tipeLayanan,
                jumlah,
                totalHarga
        );

        // ===== SIMPAN KE DATABASE =====
        transaksi.simpan(idUser);

        System.out.println("Transaksi berhasil!");
        System.out.println("Total Harga : Rp " + totalHarga);

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    // ==============================
    // CETAK TRANSAKSI
    // ==============================
   @Override
public void cetakTransaksi() {
    Transaksi.infoDB();
}
}