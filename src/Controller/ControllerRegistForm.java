/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import Model.User;
import View.RegistForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ardifirmansyah
 */
class ControllerRegistForm implements ActionListener {
    private Aplikasi model;
    private RegistForm view;
    
    public ControllerRegistForm(Aplikasi model) {
        this.model = model;
        view = new RegistForm();
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        User u = null;
        
        if (source.equals(view.getBtnRegister())) {
                /* lakukan regist */
            if (!(view.getPassword().equals(view.getPasswordAgain()))) {
                JOptionPane.showMessageDialog(view, "Password tidak sama");
            }
            else {
                try {
                    u = model.getUserByUsername(view.getUsername());
                    if (u == null) { 
                        u = new User(view.getPersonName(),
                                view.getEmail(), view.getIdentityNumber(),view.getAddress(),
                                view.getUsername(),view.getPassword());
                        model.tambahUser(u);
                        u = model.getUserByUsername(view.getUsername());
                        if (u != null) {
                            JOptionPane.showMessageDialog(view, "Registrasi berhasil. Silahkan login");
                            new ControllerLoginForm(model);
                            view.dispose();
                        }
                        else {
                            JOptionPane.showMessageDialog(view, "Registrasi gagal. Silahkan hubungi admin");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(view, "Username telah digunakan");
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerRegistForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
