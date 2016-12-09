/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.DashboardAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ardifirmansyah
 */
public class ControllerDashboardAdmin implements ActionListener {
    private Aplikasi model;
    private DashboardAdmin view;
    
    public ControllerDashboardAdmin(Aplikasi model) {
        this.model = model;
        view = new DashboardAdmin();
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnDaftarUser())) {
            try {
                view.dispose();
                new ControllerAdminDaftarUser(model);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerDashboardAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (source.equals(view.getBtnTambahVoucher())) {
            view.dispose();
            new ControllerTambahVoucher(model);
        }
        
    }
}
