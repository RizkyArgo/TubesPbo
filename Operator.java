package fotokopiku;

public class Operator extends User implements Cetak{
    public Operator(int id,String nama,String role){
        super(id, nama, role);
    }

    public static void inputTransaksi(){

    }

    @Override
    public static void cetakTransaksi(){
        System.out.println();
    }
}
