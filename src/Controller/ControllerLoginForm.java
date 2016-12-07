/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.LoginForm;
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
public class ControllerLoginForm implements ActionListener {
    private Aplikasi model;
    private LoginForm view;
    private User u;
    
    public ControllerLoginForm(Aplikasi model) throws SQLException {
        this.model = model;
        view = new LoginForm();
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        User u = null;
        
        if (source.equals(view.getBtnLogin())) {
            if (view.getUsername().equals("admin") && view.getPassword().equals("admin")) {
                new ControllerDashboardAdmin(model);
                view.dispose();
            }
            else {
                try {
                    String username = view.getUsername();
                    String password = view.getPassword();
                    u = model.getUserByUsername(username);
                    if (u != null) {
                        if (password.equals(u.getPassword())) {
                            if (u.getBlocked()) {
                                JOptionPane.showMessageDialog(view, "Akun anda di blokir. Hubungi Admin");
                            }
                            else {
                                new ControllerDashboardUser(model, u);
                                view.dispose();
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(view, "Password salah");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(view, "Username tidak ditemukan");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerLoginForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if (source.equals(view.getBtnRegister())) {
            new ControllerRegistForm(model);
            view.dispose();
        }
    }
}

