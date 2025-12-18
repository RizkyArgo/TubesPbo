package fotokopiku;

public class Layanan {

    private int idLayanan;
    private String namaLayanan;
    private int hargaPerHalaman;
    private String tipe;

    public Layanan(int idLayanan, String namaLayanan, int hargaPerHalaman,String tipe) {
        this.idLayanan = idLayanan;
        this.namaLayanan = namaLayanan;
        this.hargaPerHalaman = hargaPerHalaman;
        this.tipe = tipe;
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

    public String getTipe() {
        return tipe;
    }

    public void info() {
        System.out.println("Nama Layanan : " + namaLayanan);
        System.out.println("Harga/Halaman: " + hargaPerHalaman);
    }

    @Override
    public String toString() {
        return "ID: " + idLayanan + 
               " | Nama: " + namaLayanan +
               " | Harga: " + hargaPerHalaman;
    }
}
