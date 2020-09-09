/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.filechooser;

import com.jhw.swing.material.components.textfield.*;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.components.button._MaterialButtonIconTransparent;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.material.standards.MaterialShadow;
import com.jhw.swing.util.PersonalizationMaterial;
import com.jhw.swing.util.interfaces.BindableComponent;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.utils.icons.DerivableIcon;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialFileChooserIcon extends _PanelTransparent implements BindableComponent<List<File>>, MaterialComponent {

    public _MaterialFileChooserIcon() {
        initComponents();
        this.setIcon(MaterialIcons.FOLDER);
        addListeners();
    }

    private void initComponents() {
        fileChooser = new _MaterialFileChooser();

        buttonIcon = MaterialButtonsFactory.buildIconTransparent();
        ((_MaterialButtonIconTransparent) buttonIcon).setPaintRipple(false);

        buttonClear = MaterialButtonsFactory.buildIconTransparent();
        buttonClear.setIcon(MaterialIcons.CLEAR);

        buttonClear.setPreferredSize(new Dimension(buttonClear.getIcon().getIconWidth() * 2 - MaterialShadow.OFFSET_RIGHT, (int) buttonClear.getPreferredSize().getHeight()));

        this.setLayout(new BorderLayout());
        this.add(fileChooser);
        this.add(buttonClear, BorderLayout.EAST);
    }

    private _MaterialFileChooser fileChooser;
    private JButton buttonIcon;
    private JButton buttonClear;

    public void setIcon(ImageIcon icon) {
        if (!PersonalizationHandler.getBoolean(PersonalizationMaterial.KEY_SHOW_ICON_INPUT)) {
            return;
        }
        int h = (int) this.fileChooser.getPreferredSize().getHeight();
        if (icon instanceof DerivableIcon) {
            buttonIcon.setIcon(((DerivableIcon) icon).deriveIcon(h * _MaterialTextFieldIcon.ICON_SIZE_REDUCTION));
        } else {
            buttonIcon.setIcon(icon);
        }
        int w = (int) (h * _MaterialTextFieldIcon.ICON_WIDTH_REDUCTION);
        buttonIcon.setPreferredSize(new Dimension(w, h));
        this.add(buttonIcon, BorderLayout.WEST);
    }

    @Override
    public void setEnabled(boolean enabled) {
        fileChooser.setEnabled(enabled);
        buttonIcon.setEnabled(enabled);
    }

    public void setSelectedFiles(List<File> files) {
        fileChooser.setSelectedFiles(files);
    }

    public List<File> getSelectedFiles() {
        return fileChooser.getSelectedFiles();
    }

    @Override
    public List<File> getObject() {
        return fileChooser.getObject();
    }

    @Override
    public void setObject(List<File> object) {
        fileChooser.setObject(object);
    }

    public void clear() {
        fileChooser.clear();
    }

    private void addListeners() {
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
    }

}
