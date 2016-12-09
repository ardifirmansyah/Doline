/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import Model.User;
import View.TransferForm1;
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
public class ControllerTransferForm1 implements ActionListener {
    private Aplikasi model;
    private TransferForm1 view;
    private User u;
    
    public ControllerTransferForm1(Aplikasi model, User u) {
        this.model = model;
        this.u = u;
        view = new TransferForm1();
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        User tujuan = null;
        
        if (source.equals(view.getBtnLanjutkan())) {
            try {
                tujuan = model.getUserByUsername(view.getUserTujuan());
                if (tujuan == null) {
                    JOptionPane.showMessageDialog(view, "User tujuan tidak ditemukan");
                }
                else {
                    view.dispose();
                    new ControllerTransferForm2(model,u,tujuan,view.getNominal());
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControllerTransferForm1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
