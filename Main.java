package fotokopiku;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== APLIKASI FOTOKOPIKU =====");
        System.out.println("1. Login Admin");
        System.out.println("2. Login Operator");
        System.out.print("Pilih: ");
        int pilih = input.nextInt();
        input.nextLine();

        if (pilih == 1) {
            Admin admin = new Admin(1, "admin", "admin123");
            System.out.println("\nLogin sebagai ADMIN");
            admin.info();

            boolean jalan = true;
            while (jalan) {
                System.out.println("\n--- MENU ADMIN ---");
                System.out.println("1. Kelola Operator");
                System.out.println("2. Kelola Layanan");
                System.out.println("3. Lihat Total Pendapatan");
                System.out.println("4. Lihat Riwayat Transaksi");
                System.out.println("0. Logout");
                System.out.print("Pilih: ");
                int menu = input.nextInt();
                input.nextLine();

                switch (menu) {
                    case 1:
                        admin.kelolaOperator();
                        break;
                    case 2:
                        admin.kelolaLayanan();
                        break;
                    case 3:
                        admin.lihatTotalPendapatan();
                        break;
                    case 4:
                        admin.lihatRiwayatTransaksi();
                        break;
                    case 0:
                        jalan = false;
                        System.out.println("Logout Admin...");
                        break;
                    default:
                        System.out.println("Menu tidak tersedia");
                }
            }

        } else if (pilih == 2) {
            Operator operator = new Operator(2, "operator", "op123");
            System.out.println("\nLogin sebagai OPERATOR");
            operator.info();

            boolean jalan = true;
            while (jalan) {
                System.out.println("\n--- MENU OPERATOR ---");
                System.out.println("1. Input Transaksi");
                System.out.println("2. Cetak Transaksi");
                System.out.println("0. Logout");
                System.out.print("Pilih: ");
                int menu = input.nextInt();
                input.nextLine();

                switch (menu) {
                    case 1:
                        operator.inputTransaksi();

                        Layanan layanan = new Layanan(1, "Print Hitam Putih", 500);
                        Transaksi transaksi = new Transaksi(
                                1,
                                operator,
                                layanan,
                                10
                        );

                        transaksi.info();
                        break;

                    case 2:
                        operator.cetakTransaksi();
                        break;

                    case 0:
                        jalan = false;
                        System.out.println("Logout Operator...");
                        break;

                    default:
                        System.out.println("Menu tidak tersedia");
                }
            }

        } else {
            System.out.println("Pilihan tidak valid");
        }

        System.out.println("Terima kasih telah menggunakan FotokopiKu");
    }
}
