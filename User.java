package fotokopiku;
public abstract class User implements Cetak {
    protected int idUser;
    protected String username;
    protected String password;
    protected String role;

    public User(int idUser, String username, String password, String role) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public abstract boolean login();

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
        System.out.println("\nUsername: " + username);
        System.out.println("Role    : " + role);
    }

    @Override
    public void cetakTransaksi() {
        System.out.println("=== CETAK TRANSAKSI ===");
    }
}
