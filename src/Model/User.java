/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author PRAKTIKUM
 */
public class User extends Orang {    
    private int idUser;
    private String username;
    private String password;
    private double saldo;
    private boolean isBlocked = false;
    private ArrayList<TransactionRecord> mutasi;

        /* Contructor untuk pembuatan akun */
    public User (String nama, String email, String ktp, String alamat, 
            String username, String password) {
        super(nama, email, ktp, alamat);
        this.idUser = -1;
        this.username = username;
        this.password = password;
        this.saldo = 0;
        this.isBlocked = false;
    }
    
        /* Contructor untuk pemanggilan akun */
    public User (int idUser, String nama, String email, String ktp, String alamat,
            String username, String password, double saldo, boolean isBlocked) {
        super(nama, email, ktp, alamat);
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.saldo = saldo;
        this.isBlocked = isBlocked;
    }
    
        /* Contructor untuk pemanggilan akun */
    public User (int idUser, String nama, String email, String ktp, String alamat,
            String username, String password, double saldo, boolean isBlocked,
            ArrayList<TransactionRecord> mutasi) {
        super(nama, email, ktp, alamat);
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.saldo = saldo;
        this.isBlocked = isBlocked;
        this.mutasi = mutasi;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    public int getIdUser() {
        return idUser;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public double getSaldo() {
        return this.saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public boolean getBlocked() {
        return this.isBlocked;
    }
    
    public void setBlocked(boolean blocked) {
        this.isBlocked = blocked;
    }
}
