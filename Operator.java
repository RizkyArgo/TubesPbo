package fotokopiku;

public class Operator extends User {

    private Layanan layanan;

    public Operator(int idUser, String username, String password) {
        super(idUser, username, password, "Operator");
    }

    public void inputTransaksi() {
        System.out.println("Input transaksi oleh operator");
        System.out.println("");
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
