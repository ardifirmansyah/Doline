/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import Model.User;
import View.DashboardUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ardifirmansyah
 */
public class ControllerDashboardUser implements ActionListener {
    private Aplikasi model;
    private DashboardUser view;
    private User u;
    
    public ControllerDashboardUser(Aplikasi model, User u) {
        this.model = model;
        this.u = u;
        view = new DashboardUser();
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.addListener(this);
        view.setUserID("UDL" + u.getIdUser());
        view.setUserSaldo(u.getSaldo());
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnTopUp())) {
            new ControllerTopUpForm(model, u);
            view.dispose();
        }
        else if (source.equals(view.getBtnTransfer())) {
            new ControllerTransferForm1(model, u);
            view.dispose();
        }
    }
}
