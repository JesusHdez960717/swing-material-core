/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.colorchooser;

import com.jhw.swing.bundles.dialog.DialogPanel;
import com.jhw.swing.material.components.button.MaterialButton;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.components.container.MaterialContainersFactory;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JPanel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialColorChooser extends MaterialColorChooser {

    public static MaterialColorChooser from() {
        return new _MaterialColorChooser();
    }

    private final _MaterialColorChooserCore core = _MaterialColorChooserCore.from();

    public _MaterialColorChooser() {
        this.setText("Selector de colores");
        this.setBackground(MaterialColors.WHITE);
        addListeners();
    }

    @Override
    public Color getObject() {
        return core.getObject();
    }

    @Override
    public void setObject(Color object) {
        core.setObject(object);
    }

    private void addListeners() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showColorsPalette();
            }

        });
    }

    private void showColorsPalette() {
        Dialog d = new Dialog(core);

        JPanel panel = MaterialContainersFactory.buildPanelTransparent();
        panel.setLayout(new BorderLayout());

        MaterialButton btnAcept = MaterialButtonsFactory.buildButton();
        btnAcept.setBackground(MaterialColors.WHITE);
        btnAcept.setAction(new AbstractAction("Seleccionar", MaterialIcons.COMPUTER) {
            @Override
            public void actionPerformed(ActionEvent e) {
                _MaterialColorChooser.this.setBackground(core.getObject());
                d.dispose();
            }
        });

        panel.add(btnAcept, BorderLayout.EAST);
        d.add(panel, BorderLayout.SOUTH);
        
        d.setVisible(true);
    }

    private class Dialog extends DialogPanel {

        public Dialog(JPanel modelPanel) {
            super("Seleccione color", modelPanel);
            this.setVisible(false);
        }
    }
}
