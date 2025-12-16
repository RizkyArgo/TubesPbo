package fotokopiku;

public class Operator extends User {

    private Layanan layanan;

    public Operator(int idUser, String username, String password, String role) {
        super(idUser, username, password, role);
    }

    public void inputTransaksi() {
        System.out.println("Input transaksi oleh operator");
    }

    @Override
    public boolean login() {
        return true;
    }

    @Override
    public void cetakTransaksi() {
        System.out.println("Cetak transaksi oleh operator");
    }
}
