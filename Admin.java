package fotokopiku;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class Admin extends User {

    ArrayList<Layanan> layanans = new ArrayList<>();
    Scanner s = new Scanner(System.in);
    int pilih;
    Layanan layan;
    Transaksi tran;

    public Admin(int idUser, String username, String password) {
        super(idUser, username, password, "Admin");
    }

    @Override
    public boolean login() {
        try {
            Connection conn = Koneksi.getConnection();

            String sql = "SELECT * FROM user WHERE username=? AND password=? AND role='Admin'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.idUser = rs.getInt("id_user");
                System.out.println("Login Admin berhasil!");
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Login Admin gagal!");
        return false;
    }

    public void kelolaLayanan() {
        do {
            System.out.println("\n=== Kelola Layanan ===");
            System.out.println("1. Tambah Layanan");
            System.out.println("2. Hapus Layanan");
            System.out.println("3. Tampilkan Layanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");

            pilih = s.nextInt();

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan Nama Layanan: ");
                    String nama = s.next();

                    System.out.print("Masukkan Harga per Halaman: ");
                    int harga = s.nextInt();

                    System.out.println("Masukkan Tipe Layanan (Warna/Buram): ");
                    String tipe = s.next();

                    try {
                        Connection conn = Koneksi.getConnection();                           
                        String sql = "INSERT INTO layanan (nama_layanan, harga_per_lembar, tipe_layanan) VALUES (?,?,?)";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, nama);
                        ps.setInt(2, harga);
                        ps.setString(3, tipe);
                        ps.executeUpdate();
                        System.out.println("Layanan berhasil ditambahkan ke database!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.print("Masukkan Nama Layanan Yang Ingin Dihapus: ");
                    String hapus = s.next();

                    try {
                    Connection conn = Koneksi.getConnection();
                    String sql = "DELETE FROM layanan WHERE nama_layanan =?";  
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, hapus); 
                    ps.executeUpdate();
                    System.out.println("Layanan Berhasil Dihapus");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    layan.infoDB();
                    // try {
                    //     Connection conn = Koneksi.getConnection();

                    //     String sql = "SELECT * FROM layanan";
                    //     PreparedStatement ps = conn.prepareStatement(sql);
                    //     ResultSet rs = ps.executeQuery();

                    //     System.out.println("=== DAFTAR LAYANAN ===");
                    //     while (rs.next()) {
                    //         System.out.println(
                    //             rs.getInt("id_layanan") + " | " + rs.getString("nama_layanan") + " | " + rs.getInt("harga_per_lembar") + " | " + rs.getString("tipe_layanan")
                    //         );
                    //     }
                    // } catch (Exception e) {
                    //     e.printStackTrace();
                    // }
                case 0:
                    System.out.println("Keluar dari menu layanan");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 0);
    }

    public void kelolaOperator() {
        do {
            System.out.println("\n=== Kelola Operator ===");
            System.out.println("1. Tambah Operator");
            System.out.println("2. Hapus Operator");
            System.out.println("3. Tampilkan Daftar Operator");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");

            pilih = s.nextInt();

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan Username Operator: ");
                    String username = s.next();

                    System.out.print("Masukkan Password: ");
                    String pass = s.next();

                     try {
                        Connection conn = Koneksi.getConnection();   
                        String sql = "INSERT INTO user (username, password, role) VALUES (?, ?, 'operator')";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, username);
                        ps.setString(2, pass);
                        ps.executeUpdate();
                        System.out.println("Operator berhasil ditambahkan!");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    break;

                case 2:
                    System.out.print("Masukkan Nama Operator Yang Ingin Dihapus: ");
                    String hapus = s.next();

                    try {
                    Connection conn = Koneksi.getConnection();
                    String sql = "DELETE FROM user WHERE username =?";  
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, hapus); 
                    ps.executeUpdate();
                    System.out.println("Operator Berhasil Dihapus");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    try {
                        Connection conn = Koneksi.getConnection();

                        String sql = "SELECT * FROM user WHERE role = 'operator'";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery();

                        System.out.println("=== DAFTAR OPERATOR ===");
                        while (rs.next()) {
                            System.out.println(
                                rs.getInt("id_user") + " | " + rs.getString("username") + " | " + rs.getString("role")
                            );
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                case 0:
                    System.out.println("Keluar dari menu layanan");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 0);
    }

    public void lihatTotalPendapatan() {
        tran.totalHarga(pilih);//harusnya gapake param
        // try {
        //     Connection conn = Koneksi.getConnection();

        //     String sql = "SELECT SUM(total_harga) AS total FROM transaksi";
        //     PreparedStatement ps = conn.prepareStatement(sql);
        //     ResultSet rs = ps.executeQuery();

        //     if (rs.next()) {
        //         int total = rs.getInt("total");
        //         System.out.println("\nTotal Pendapatan: Rp." + total);
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }

    public void lihatRiwayatTransaksi() {
        tran.infoDB();//lom ke tampil di terminal
        // System.out.println("Menampilkan riwayat transaksi");
        // try {
        //     Connection conn = Koneksi.getConnection();
        //     String sql = "SELECT tgl_transaksi,nama_pelanggan,tipe_layanan,total_harga FROM transaksi";
        //     PreparedStatement ps = conn.prepareStatement(sql);
        //     ResultSet rs = ps.executeQuery();

        //     if (rs.next()) {
               
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }
}
