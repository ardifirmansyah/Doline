/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.Aplikasi;
import Model.User;
import View.AdminDaftarUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ardifirmansyah
 */
public class ControllerAdminDaftarUser extends MouseAdapter implements ActionListener {
    private Aplikasi model;
    private AdminDaftarUser view;
    private int selected;
    private Database connection;
    
    public ControllerAdminDaftarUser(Aplikasi model) throws SQLException {
        this.model = model;
        view = new AdminDaftarUser();
        view.viewAllUser(model.loadAllUser());
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.addListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        Object source = me.getSource();
        
        if (source.equals(view.getTblUser())) {
            try {
                int selected = view.getSelectedUser();
                User u = connection.loadAllUser().get(selected);
            }
            catch (SQLException ex) {
                Logger.getLogger(ControllerAdminDaftarUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnKembali())) {
            new ControllerDashboardAdmin(model);
            view.dispose();
        }
        else if (source.equals(view.getBtnBlokir())) {
            try {
                int selected = view.getSelectedUser() + 1;
                if (selected != -1) {
                    System.out.println(selected);
                    User u = model.getUserByID(selected);
                    u.setBlocked(!(u.getBlocked()));
                    model.updateUser(u);
                    view.viewAllUser(model.loadAllUser());
                }
                else {
                    JOptionPane.showMessageDialog(view, "Anda belum memilih User");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControllerAdminDaftarUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
