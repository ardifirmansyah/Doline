/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Arian Nurrifqhi
 */
public class TransactionRecord implements Serializable {
    private long idTransaksi;
    private User fromUser;
    private User toUser;
    private double jumlah;
    private Date tanggalTransaksi;

    public long getIdTransaksi() {
        return idTransaksi;
    }
    
    public void setIdTransaksi(long idTransaksi) {
        this.idTransaksi = idTransaksi;
    }
    
    public User getFromUser() {
        return fromUser;
    }
    
    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }
    
    public User getToUser() {
        return toUser;
    }
    
    public void setToUser(User toUser) {
        this.toUser = toUser;
    }
    
    public double getJumlah() {
        return jumlah;
    }
    
    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }
    
    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }
    
    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }   
}
