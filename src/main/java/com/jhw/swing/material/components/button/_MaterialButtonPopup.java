/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.button;

import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.injection.Background_Force_Foreground;
import com.jhw.swing.material.injection.Foreground_Force_Icon;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.material.standards.MaterialShadow;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _MaterialButtonPopup extends _MaterialButton {

    public static _MaterialButtonPopup from() {
        return new _MaterialButtonPopup();
    }

    protected _MaterialButtonPopup() {
        presonalize();
        addListeners();
    }

    private void presonalize() {
        this.setBackground(PersonalizationHandler.getColor(Personalization.KEY_COLOR_BACKGROUND_PANEL));
        this.setAccentColorFadeInto(MaterialColors.BLUEGREY_50);
        this.setPaintRipple(false);
        this.setBorderThickness(2);
        this.setIcon(MaterialIcons.FILE_UPLOAD);
    }

    private void addListeners() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showPopup(e);
            }
        });
    }

    private void showPopup(MouseEvent e) {
        if (getComponentPopupMenu() != null) {
//            getComponentPopupMenu().show(this, e.getX(), e.getY());
            getComponentPopupMenu().show(this, 0 + MaterialShadow.OFFSET_LEFT, (int) this.getSize().getHeight() - MaterialShadow.OFFSET_BOTTOM);

        }
    }
}
