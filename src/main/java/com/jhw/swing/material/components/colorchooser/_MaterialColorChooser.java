/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.colorchooser;

import com.jhw.swing.bundles.dialog.DialogPanel;
import com.jhw.swing.material.components.button.MaterialButton;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.components.button._MaterialButton;
import com.jhw.swing.material.components.container.MaterialContainersFactory;
import com.jhw.swing.material.injection.Background_Force_Foreground;
import com.jhw.swing.material.injection.Foreground_Force_Icon;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JPanel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _MaterialColorChooser extends MaterialColorChooser {
    
    public static MaterialColorChooser from() {
        return MaterialSwingInjector.getImplementation(_MaterialColorChooser.class);
    }
    
    private final _MaterialColorChooserCore core = _MaterialColorChooserCore.from();
    private final Dialog dialog = new Dialog(core);
    
    public _MaterialColorChooser() {
        this.setText("Selector de colores");
        this.setBackground(MaterialColors.WHITE);
        initColorsPalette();
        addListeners();
        this.setBorderThickness(2f);
        this.setBorderColor(MaterialColors.BLACK);
    }
    
    @Override
    public Color getObject() {
        return core.getObject();
    }
    
    @Override
    public void setObject(Color object) {
        core.setObject(object);
        this.setBackground(core.getObject());
    }
    
    private void addListeners() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
            
        });
    }
    
    private void initColorsPalette() {
        JPanel panel = MaterialContainersFactory.buildPanelTransparent();
        panel.setLayout(new BorderLayout());
        
        MaterialButton btnAcept = MaterialButtonsFactory.buildButton();
        btnAcept.setBorderColor(MaterialColors.BLACK);
        btnAcept.setBorderThickness(2f);
        btnAcept.setBackground(MaterialColors.WHITE);
        btnAcept.setAction(new AbstractAction("Seleccionar", MaterialIcons.CHECK) {
            @Override
            public void actionPerformed(ActionEvent e) {
                setObject(core.getObject());
                dialog.setVisible(false);
            }
        });
        btnAcept.setPreferredSize(new Dimension((int) btnAcept.getPreferredSize().getWidth(), 50));
        
        panel.add(btnAcept, BorderLayout.EAST);
        dialog.add(panel, BorderLayout.SOUTH);
        
    }
    
    private class Dialog extends DialogPanel {
        
        public Dialog(JPanel modelPanel) {
            super("Seleccione color", modelPanel, false);
        }
    }
}
