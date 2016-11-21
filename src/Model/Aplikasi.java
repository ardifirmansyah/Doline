/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Database;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PRAKTIKUM
 */
public class Aplikasi {
    private ArrayList<User> daftarUser;
    private Database connection;
    
    public Aplikasi() throws SQLException {
        connection = new Database();
        if (connection.connect() != null) {
            System.out.println("Koneksi berhasil");
        } 
//        this.daftarUser = connection.loadAllUser();
    }
    
    public void tambahUser(User user) throws SQLException {
        daftarUser.add(user);
        connection.saveUser(user);
    }
        
        /* getUser untuk login */
    public User getUserByUsername(String username) throws SQLException {
        for (User u : daftarUser) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
    
    public void blokirUser(User user) {
        user.setBlocked(true);
    }
} 
