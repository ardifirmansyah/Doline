/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import Model.Voucher;
import View.TambahVoucherForm;
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
public class ControllerTambahVoucher implements ActionListener {
    private Aplikasi model;
    private TambahVoucherForm view;
    
    public ControllerTambahVoucher(Aplikasi model) {
        this.model = model;
        view = new TambahVoucherForm();
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        Voucher v = null;
        
        if (source.equals(view.getBtnTambahVoucher())) {
            try {
                String kode = view.getKodeVoucher();
                long nominal = view.getNominal();
                
                v = model.getVoucher(view.getKodeVoucher());
                
                if (v == null) {
                    v = new Voucher(kode,nominal);
                    model.tambahVoucher(v);
                    v = model.getVoucher(view.getKodeVoucher());
                    if (v != null) {
                        JOptionPane.showMessageDialog(view, "Voucher berhasil ditambah");
                        view.dispose();
                        new ControllerDashboardAdmin(model);
                    }
                    else {
                        JOptionPane.showMessageDialog(view, "Penambahan voucher gagal");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(view, "Kode voucher telah terdaftar");
                }
            } catch (SQLException | NumberFormatException ex) {
                Logger.getLogger(ControllerRegistForm.class.getName()).log(Level.SEVERE, null, ex);
                if (ex instanceof NumberFormatException) {
                    JOptionPane.showMessageDialog(view, "Nominal salah, masukkan hanya angka");
                }
            }
        }
    }
}
