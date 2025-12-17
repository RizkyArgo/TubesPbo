package fotokopiku;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Admin> adminList = new ArrayList<>();
        ArrayList<Operator> operatorList = new ArrayList<>();
        ArrayList<Layanan> layananList = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        System.out.println("===== APLIKASI FOTOKOPIKU =====");
        System.out.println("1. Login Admin");
        System.out.println("2. Login Operator");
        System.out.print("Pilih: ");
        int pilih = input.nextInt();
        input.nextLine();

        if (pilih == 1) {
            Admin admin = new Admin(0, null, null);
            System.out.print("Masukkan Id: ");
            admin.setIdUser(input.nextInt());
            System.out.print("Masukkan Username: ");
            admin.setUsername(input.next());
            System.out.print("Masukkan Password: ");
            admin.setPassword(input.next());
            admin.setRole("ADMIN");

            adminList.add(admin);
            
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
            Operator operator = new Operator(0, null, null, null);
            System.out.print("Masukkan Id: ");
            operator.setIdUser(input.nextInt());
            System.out.print("Masukkan Username: ");
            operator.setUsername(input.next());
            System.out.print("Masukkan Password: ");
            operator.setPassword(input.next());
            operator.setRole("ADMIN");
            System.out.println("\nLogin sebagai OPERATOR");
            operator.info();

            operatorList.add(operator);

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

                        Layanan layanan = new Layanan(0, null, 0);
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
