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
                
                v = model.getVoucher(kode);
                
                if (v == null) {
                    v = new Voucher(kode,nominal);
                    model.tambahVoucher(v);
                    v = model.getVoucher(kode);
                    if (v != null) {
                        JOptionPane.showMessageDialog(view, "Voucher berhasil ditambah");
                        view.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(view, "Penambahan voucher gagal");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(view, "Kode voucher telah terdaftar");
                }
            } catch (Exception e) {
            }
        }
    }
}
