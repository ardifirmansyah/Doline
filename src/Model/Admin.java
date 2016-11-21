/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Arian Nurrifqhi
 */
public class Admin {
    private String username_admin;
    private String password_admin;

    public String getUsername_admin() {
        return username_admin;
    }

    public void setUsername_admin(String username_admin) {
        this.username_admin = username_admin;
    }
    
    public boolean confirm_kode(String code1, String code2){
        if(code1 == code2){
            return true;
        }
        else
            return false;
    }
}
