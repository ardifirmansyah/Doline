/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ardifirmansyah
 */
public class Database {
        /* location server mysql */
    private final String server = "jdbc:mysql://localhost/doline";
        /* user db */
    private final String dbUser = "root";
        /* password db */
    private final String dbPassword = "";
    
    private Statement statement;
    private Connection connection;
    
    public Connection connect() throws SQLException {
        connection = DriverManager.getConnection(server, dbUser, dbPassword);
        statement = connection.createStatement();
        return connection;
    }
    
    public void saveUser(User u) throws SQLException {
        /* memasukkan record user ke database */
            /* query insert user */
        String query = "insert into user "
                + "(Nama,Email,KTP,Alamat,Username,Password,Saldo,Blocked) values ("
                + "'" + u.getNama() + "',"
                + "'" + u.getEmail() + "',"
                + "'" + u.getKtp() + "',"
                + "'" + u.getAlamat() + "',"
                + "'" + u.getUsername() + "',"
                + "'" + u.getPassword() + "',"
                + u.getSaldo() + ","
                + u.getBlocked() + ")"; 
            /* eksekusi query dan generate id user */
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        int generatedIdUser = -1;
        if (rs.next()) {
            generatedIdUser = rs.getInt(1);
        }
        u.setIdUser(generatedIdUser);
    }
    
    public User getUser(String username) throws SQLException {
            /* mencari record user dari database */
        User u = null;
            /* query select user */
        String query = "select * from user where Username='" + username + "'"; 
            /* eksekusi query */
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
                /* sesuaikan dengan konstruktor user */
            u = new User(rs.getInt(1), rs.getString(2),
                    rs.getString(3),rs.getString(4),rs.getString(5),
                    rs.getString(6),rs.getString(7),rs.getDouble(8),
                    rs.getBoolean(9));
        }
        return u;
    }
 
    public User getUserByID(int id) throws SQLException {
            /* mencari record user dari database */
        User u = null;
            /* query select user */
        String query = "select * from user where ID=" + id + ""; 
            /* eksekusi query */
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
                /* sesuaikan dengan konstruktor user */
            u = new User(rs.getInt(1), rs.getString(2),
                    rs.getString(3),rs.getString(4),rs.getString(5),
                    rs.getString(6),rs.getString(7),rs.getDouble(8),
                    rs.getBoolean(9));
        }
        return u;
    }
    
    public Voucher getVoucher(String kode) throws SQLException {
            /* mencari record voucher dari database by kode */
        Voucher v = null;
            /* query select voucher */
        String query = "select * from voucher where kode='" + kode + "'"; 
            /* eksekusi query */
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
                /* sesuaikan dengan konstruktor user */
            v = new Voucher(rs.getString(1), rs.getLong(2), rs.getBoolean(3));
        }
        return v;
    }
    
    public void tambahVoucher(Voucher v) throws SQLException {
        /* memasukkan record user ke database */
            /* query insert user */
        String query = "insert into voucher "
                + "(kode,nominal,used) values ("
                + "'" + v.getKode() + "'," + v.getNominal() + "," + v.getUsed() + ")"; 
            /* eksekusi query dan generate id user */
        statement.execute(query);
    }
    
    public void saveTransaksi(TransactionRecord tr) throws SQLException {
        /* memasukkan record transaksi ke database */
            /* query insert transaksi */
        String query = ""; 
            /* eksekusi query dan generate id transaksi */
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        int generatedIdTransaksi = -1;
        if (rs.next()) {
            generatedIdTransaksi = rs.getInt(1);
        }
        tr.setIdTransaksi(generatedIdTransaksi);
    }
    
    public TransactionRecord getTransaksi(long idTransaksi) throws SQLException {
        /* mencari record transaksi dari database */
        TransactionRecord tr = null;
            /* query select transaksi */
        String query = ""; 
            /* eksekusi query */
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
                /* sesuaikan dengan konstruktor user */
            tr = new TransactionRecord();
        }
        return tr;
    }
    
    public ArrayList<User> loadAllUser() throws SQLException {
        ArrayList<User> daftarUser = new ArrayList<>();
        User u = null;
        String query = "select * from User";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            u = new User(rs.getInt(1), rs.getString(2),
                    rs.getString(3),rs.getString(4),rs.getString(5),
                    rs.getString(6),rs.getString(7),rs.getDouble(8),
                    rs.getBoolean(9));
            daftarUser.add(u);
        }
        return daftarUser;
    }
    
    public void updateUser(User u) throws SQLException {
        String query = "update user set "
                + "Nama = '" + u.getNama() + "',"
                + "Email = '" + u.getEmail() + "',"
                + "KTP = '" + u.getKtp() + "',"
                + "Alamat = '" + u.getAlamat() + "',"
                + "Password = '" + u.getPassword() + "',"
                + "Blocked = " + u.getBlocked() + ","
                + "where ID = " + u.getIdUser();
        statement.executeUpdate(query);
    }
}
