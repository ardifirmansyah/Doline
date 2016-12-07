/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import Model.User;
import View.TopUpForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            
        }
    }
}
