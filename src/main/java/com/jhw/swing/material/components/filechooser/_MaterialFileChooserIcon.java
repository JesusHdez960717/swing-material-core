/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.filechooser;

import com.jhw.swing.material.components.textfield.*;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.components.button._MaterialButtonIconTransparent;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.util.PersonalizationMaterial;
import com.jhw.swing.util.interfaces.BindableComponent;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.utils.icons.DerivableIcon;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialFileChooserIcon extends _PanelTransparent implements BindableComponent<List<File>>, MaterialComponent {

    public _MaterialFileChooserIcon() {
        initComponents();
        this.setIcon(MaterialIcons.FOLDER);
    }

    private void initComponents() {
        fileChooser = new _MaterialFileChooser();
        
        buttonIcon = new _MaterialButtonIconTransparent();
        buttonIcon.setRippleColor(MaterialColors.TRANSPARENT);

        this.setLayout(new BorderLayout());
        this.add(fileChooser, BorderLayout.CENTER);
    }

    private _MaterialFileChooser fileChooser;
    private _MaterialButtonIconTransparent buttonIcon;

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

    public List<File> getObject() {
        return fileChooser.getObject();
    }

    public void setObject(List<File> object) {
        fileChooser.setObject(object);
    }

}
