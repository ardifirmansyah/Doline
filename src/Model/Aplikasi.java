/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Database;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author PRAKTIKUM
 */
public class Aplikasi {
    private ArrayList<User> daftarUser;
    private Database connection;
    
    public Aplikasi() throws SQLException {
//        daftarUser = new ArrayList<>();
        try {
            connection = new Database();
            if (connection.connect() != null) {
                JOptionPane.showMessageDialog(new JFrame(), "Koneksi berhasil");
            }
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(new JFrame(), se.getMessage());
            JOptionPane.showMessageDialog(new JFrame(), "Akan keluar program");
            System.exit(0);
        }
//        this.daftarUser = connection.loadAllUser();
    }
    
    public ArrayList loadAllUser() throws SQLException {
        return connection.loadAllUser();
    }
    
    public void tambahUser(User user) throws SQLException {
//        daftarUser.add(user);
        connection.saveUser(user);
    }
        
        /* getUser untuk login */
    public User getUserByUsername(String username) throws SQLException {
        return connection.getUser(username);
    }
    
    public void tambahVoucher(Voucher v) throws SQLException {
        connection.tambahVoucher(v);
    }
    
    public Voucher getVoucher(String kode) throws SQLException {
        return connection.getVoucher(kode);
    }
    
    public void blokirUser(User user) {
        user.setBlocked(true);
    }
} 
