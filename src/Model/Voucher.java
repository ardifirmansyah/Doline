/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ardifirmansyah
 */
public class Voucher {
    private String kode;
    private long nominal;
    private boolean used;
    
    public Voucher(String kode) {
        this.kode = kode;
    }
    
    public Voucher(String kode, long nominal) {
        this.kode = kode;
        this.nominal = nominal;
    }
    
    public void setKode(String kode) {
        this.kode = kode;
    }
    
    public String getKode() {
        return kode;
    }
    
    public void setNominal(long nominal) {
        this.nominal = nominal;
    }
    
    public long getNominal() {
        return nominal;
    }
    
    public void setUsed(boolean used) {
        this.used = used;
    }
    
    public boolean getUsed() {
        return used;
    }
}
