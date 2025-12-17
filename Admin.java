package fotokopiku;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
    ArrayList<Layanan> layanans = new ArrayList<>();
    Scanner s = new Scanner(System.in);
    Layanan layanan;
    int pilih;

    public Admin(int idUser, String username, String password) {
        super(idUser, username, password, "Admin");
    }

    public void kelolaOperator() {
        System.out.println("Admin mengelola data operator");
    }

    public void kelolaLayanan() {
        do {
            System.out.println("Operasi Layanan");
            System.out.println("1. Tambah Layanan");
            System.out.println("2. Hapus Layanan");
            System.out.println("3. Tampilkan Layanan");
            switch (pilih = s.nextInt()) {
                case 1:
                    System.out.print("Masukkan Id : ");
                        int idLayanan = s.nextInt();
                    System.out.print("Masukkan Harga per Halaman: ");
                        int harga = s.nextInt();
                    System.out.print("Masukkan Nama Layanan: ");
                        String nama = s.next();
                    Layanan lay = new Layanan(idLayanan, nama, harga);
                        layanans.add(lay);
                    break;
                case 2:

                    break;
                case 3:
                    for (Layanan elem : layanans) {
                        System.out.println(elem);
                    }
                    toString();
                    break;
                default:
                    break;
            }
        } while(pilih != 0);
        
    }

    public void lihatTotalPendapatan() {
        System.out.println("Menampilkan total pendapatan");
    }

    public void lihatRiwayatTransaksi() {
        System.out.println("Menampilkan riwayat transaksi");
    }

    @Override
    public boolean login() {
        return true;
    }

    @Override
    public String toString() {
        return "Admin [layanans=" + layanans + "]";
    }

   
}
