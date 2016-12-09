/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import Model.User;
import View.TransferForm2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ardifirmansyah
 */
class ControllerTransferForm2 implements ActionListener {
    private Aplikasi model;
    private TransferForm2 view;
    private User u;
    private User tujuan;

    public ControllerTransferForm2(Aplikasi model, User u, User tujuan, double nominal) {
        this.model = model;
        this.u = u;
        this.tujuan = tujuan;
        view = new TransferForm2();
        view.setNamaTujuan(tujuan.getNama());
        view.setUsernameTujuan(tujuan.getUsername());
        view.setNominalTransfer(nominal);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnKonfirmasi())) {
            
        }
    }
    
}
