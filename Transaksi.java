package fotokopiku;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.math.BigDecimal;

public class Transaksi {

    // ===== ATTRIBUTE (CLASS DIAGRAM) =====
    private int idTransaksi;
    private Operator operator;
    private Layanan layanan;
    private int jumlahLembar;

    // ===== CONSTRUCTOR =====
    public Transaksi(int idTransaksi, Operator operator, Layanan layanan, int jumlahLembar) {
        this.idTransaksi = idTransaksi;
        this.operator = operator;
        this.layanan = layanan;
        this.jumlahLembar = jumlahLembar;
    }

<<<<<<< HEAD
    public int totalHarga(int jumlah) {//ni ntar jumlah * harga per halaman
=======
    // ===== LOGIC OOP (CLASS DIAGRAM) =====
    public BigDecimal totalHarga(int jumlah) {
>>>>>>> 026dff554e987783be394085e587bf042b37c923
        return layanan.cekHarga(jumlah);
    }

    public void info() {
        System.out.println("=== TRANSAKSI (OBJECT) ===");
        System.out.println("ID Transaksi : " + idTransaksi);
        System.out.println("Operator     : " + operator.getNama());
        System.out.println("Layanan      : " + layanan.getNama());
        System.out.println("Jumlah       : " + jumlahLembar);
        System.out.println("Total Harga  : " + totalHarga(jumlahLembar));
    }

    // ===== DATABASE (ERD) =====
    public static void infoDB() {
        try {
            Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM transaksi";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("=== DATA TRANSAKSI ===");
            while (rs.next()) {
                System.out.println(
                    "ID Transaksi  : " + rs.getInt("id_transaksi") +
                    "\nTanggal      : " + rs.getDate("tgl_transaksi") +
                    "\nPelanggan    : " + rs.getString("nama_pelanggan") +
                    "\nJumlah Lbr   : " + rs.getInt("jumlah_lembar") +
                    "\nTotal Harga  : " + rs.getBigDecimal("total_harga") +
                    "\n----------------------"
                );
            }

        } catch (Exception e) {
            System.out.println("Gagal mengambil data transaksi");
            e.printStackTrace();
        }
    }
}
