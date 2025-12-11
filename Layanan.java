package fotokopiku;

public class Layanan {
    private int idLayanan;
    private String namaLayanan;
    private int hargaperHalaman;

    public Layanan(int idLayanan,String namaLayanan,int hargaperHalaman){
        this.idLayanan = idLayanan;
        this.namaLayanan=namaLayanan;
        this.hargaperHalaman=hargaperHalaman;
    }

    public static void getHarga(){

    }

    public int getIdLayanan() {
        return idLayanan;
    }

    public String getNamaLayanan() {
        return namaLayanan;
    }

    public int getHargaperHalaman() {
        return hargaperHalaman;
    }

    public void info(){
        System.out.println("=== INFO ===");
        System.out.println("Nama Layanan: " + namaLayanan);
        System.out.println("Harga per halaman: " + hargaperHalaman);
    }
}
