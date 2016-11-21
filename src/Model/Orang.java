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
public abstract class Orang {
    private String nama;
    private String email;
    private String ktp;
    private String alamat;
    private String hp;
    
    public Orang(String nama, String email, String ktp, String alamat) {
        this.nama = nama;
        this.email = email;
        this.ktp = ktp;
        this.alamat = alamat;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setKtp(String ktp) {
        this.ktp = ktp;
    }
    
    public String getKtp() {
        return ktp;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getAlamat() {
        return alamat;
    }
    
    public void setHp(String hp) {
        this.hp = hp;
    }
    
    public String getHp() {
        return hp;
    }
    
    @Override
    public String toString() {
        String s = "No. Identity : " + ktp + "\n"
                + "Nama : " + nama + "\n"
                + "Email : " + email + "\n"
                + "HP : " + hp;
        return s;
    }
}
