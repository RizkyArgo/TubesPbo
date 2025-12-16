package fotokopiku;

public class Admin extends User {

    public Admin(int idUser, String username, String password) {
        super(idUser, username, password, "Admin");
    }

    public void kelolaOperator() {
        System.out.println("Admin mengelola data operator");
    }

    public void kelolaLayanan() {
        System.out.println("Admin mengelola data layanan");
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
}
