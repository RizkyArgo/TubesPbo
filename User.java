/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fotokopiku;

/**
 *
 * @author VICTUS
 */
abstract class User implements Cetak {
    private int idUser;
    private String nama;
    private String password;
    private String roles;

    public User(int idUser,String nama,String password,String roles){
        this.idUser = idUser;
        this.nama = nama;
        this.password = password;
        this.roles = roles;
    }
    
    public int getIdUser() {
        return idUser;
    }

    public String getNama() {
        return nama;
    }

    public String getPassword() {
        return password;
    }
    
    public String getRoles() {
        return roles;
    }

    public void info(){
        System.out.println("=== INFO ===");
        System.out.println("Id user: " + idUser);
        System.out.println("Nama user: " + nama);
        System.out.println("Role: " + roles);
    }

    public static boolean login(){
     return false;
    }
    
    @Override
    public void cetakTransaksi(){
        System.out.println("=== STRUK ===");
    }
}
