package fotokopiku;

public abstract class User implements Cetak {

    protected int idUser;
    protected String username;
    protected String password;
    protected String role;

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(int idUser, String username, String password, String role) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public boolean login() {
        return true;
    }

    public int getId() {
        return idUser;
    }

    public String getNama() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public void info() {
        System.out.println("ID User : " + idUser);
        System.out.println("Username: " + username);
        System.out.println("Role    : " + role);
    }

    @Override
    public void cetakTransaksi() {
        System.out.println("=== CETAK TRANSAKSI ===");
    }
}
