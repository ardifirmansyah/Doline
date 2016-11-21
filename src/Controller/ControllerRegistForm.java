/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.RegistForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ardifirmansyah
 */
class ControllerRegistForm implements ActionListener {
    private Aplikasi model;
    private RegistForm view;
    
    public ControllerRegistForm(Aplikasi model) {
        this.model = model;
        view = new RegistForm();
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
}
