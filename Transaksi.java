package fotokopiku;

public class Transaksi {

    private int idTransaksi;
    private Operator operator;
    private Layanan layanan;
    private int jumlahLembar;

    public Transaksi(int idTransaksi, Operator operator, Layanan layanan, int jumlahLembar) {
        this.idTransaksi = idTransaksi;
        this.operator = operator;
        this.layanan = layanan;
        this.jumlahLembar = jumlahLembar;
    }

    public int totalHarga(int jumlah) {
        return layanan.cekHarga(jumlah);
    }

    public void info() {
        System.out.println("=== TRANSAKSI ===");
        System.out.println("ID Transaksi : " + idTransaksi);
        System.out.println("Operator     : " + operator.getNama());
        System.out.println("Layanan      : " + layanan.getNama());
        System.out.println("Jumlah       : " + jumlahLembar);
        System.out.println("Total Harga  : " + totalHarga(jumlahLembar));
    }
}
