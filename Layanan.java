package fotokopiku;

public class Layanan {

    private int idLayanan;
    private String namaLayanan;
    private int hargaPerHalaman;

    public Layanan(int idLayanan, String namaLayanan, int hargaPerHalaman) {
        this.idLayanan = idLayanan;
        this.namaLayanan = namaLayanan;
        this.hargaPerHalaman = hargaPerHalaman;
    }

    public int cekHarga(int jumlah) {
        return jumlah * hargaPerHalaman;
    }

    public int getId() {
        return idLayanan;
    }

    public String getNama() {
        return namaLayanan;
    }

    public int getHargaPerHalaman() {
        return hargaPerHalaman;
    }

    public void info() {
        System.out.println("Nama Layanan : " + namaLayanan);
        System.out.println("Harga/Halaman: " + hargaPerHalaman);
    }
}
