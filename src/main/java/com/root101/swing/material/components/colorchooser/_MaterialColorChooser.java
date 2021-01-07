/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.material.components.colorchooser;

import com.root101.swing.bundles.dialog.DialogPanel;
import com.root101.swing.material.components.button.MaterialButton;
import com.root101.swing.material.components.button.MaterialButtonsFactory;
import com.root101.swing.material.components.container.MaterialContainersFactory;
import com.root101.swing.material.injection.Background_Force_Foreground;
import com.root101.swing.material.injection.Foreground_Force_Icon;
import com.root101.swing.material.injection.MaterialSwingInjector;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialIcons;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JPanel;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
