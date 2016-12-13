/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import Model.User;
import Model.Voucher;
import View.TopUpForm;
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
public class ControllerTopUpForm implements ActionListener {
    private Aplikasi model;
    private TopUpForm view;
    private User u;
    
    public ControllerTopUpForm(Aplikasi model, User u) {
        this.model = model;
        this.u = u;
        view = new TopUpForm();
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnOK())) {
            try {
                Voucher v = model.getVoucher(view.getKodeVoucher());
                if (v != null) {
                    if (v.getUsed()) {
                        JOptionPane.showMessageDialog(view, "Voucher telah digunakan");
                    }
                    else {
                        try {
                            double saldo = u.getSaldo() + v.getNominal();
                            v.setUsed(true);
                            model.updateVoucher(v);
                            u.setSaldo(saldo);
                            model.updateUser(u);
                            v = model.getVoucher(view.getKodeVoucher());
                            if (v.getUsed()) {
                                JOptionPane.showMessageDialog(view, "Saldo berhasil ditambahkan!");
                                view.dispose();
                                new ControllerDashboardUser(model, u);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(ControllerTopUpForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControllerTopUpForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
