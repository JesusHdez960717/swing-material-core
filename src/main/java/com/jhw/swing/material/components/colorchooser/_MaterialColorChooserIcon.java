/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.colorchooser;

import com.jhw.swing.material.components.textfield.*;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.components.button.MaterialButtonIcon;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.util.PersonalizationMaterial;
import com.jhw.swing.utils.icons.DerivableIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Icon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialColorChooserIcon extends MaterialColorChooserIcon {

    public static MaterialColorChooserIcon from() {
        return new _MaterialColorChooserIcon();
    }

    public _MaterialColorChooserIcon() {
        initComponents();
        this.setIcon(MaterialIcons.PALETTE);
    }

    private void initComponents() {
        colorChooser = MaterialColorChooserFactory.build();

        buttonIcon = MaterialButtonsFactory.buildIconTransparent();
        buttonIcon.setPaintRipple(false);

        this.setBorder(null);
        this.setLayout(new BorderLayout());
        this.add(colorChooser, BorderLayout.CENTER);

    }

    private MaterialColorChooser colorChooser;
    private MaterialButtonIcon buttonIcon;

    @Override
    public MaterialColorChooser getColorChooser() {
        return colorChooser;
    }

    @Override
    public void setIcon(Icon icon) {
        if (!PersonalizationHandler.getBoolean(PersonalizationMaterial.KEY_SHOW_ICON_INPUT)) {
            return;
        }

        int h = (int) this.colorChooser.getPreferredSize().getHeight();
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
    public Icon getIcon() {
        return buttonIcon.getIcon();
    }

    @Override
    public void setEnabled(boolean enabled) {
        colorChooser.setEnabled(enabled);
        buttonIcon.setEnabled(enabled);
    }

    @Override
    public Color getObject() {
        return colorChooser.getObject();
    }

    @Override
    public void setObject(Color object) {
        colorChooser.setObject(object);
    }

}
