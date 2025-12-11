/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fotokopiku;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author VICTUS
 */
public class DbFotokopiku {
    private Connection conn;
    private final Koneksi k = new Koneksi();

    public ArrayList<User> getUser() throws SQLException{
        ArrayList<User> daftar = new ArrayList<>();
        conn = k.getConnection();
        
        String kueri = "SELECT * FROM user";
        PreparedStatement ps = conn.prepareStatement(kueri);
        
        ResutltSet rs = ps.executeQuery();
        while (rs.next()){
            String id = rs.getString("userId");
            String nama = rs.getString("nama");
            String roles = rs.getString("roles");
            
            User u = null;
            
            
        }
    }
}