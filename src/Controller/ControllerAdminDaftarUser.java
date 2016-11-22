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
        view.viewAllUser(connection.loadAllUser());
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
        
//        if (source.equals(view.getBtnUbah()))
    }
}
