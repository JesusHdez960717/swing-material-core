/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.button;

import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.material.standards.MaterialShadow;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialButtonPopup extends _MaterialButton {

    public static _MaterialButtonPopup from() {
        return new _MaterialButtonPopup();
    }

    public static _MaterialButtonPopup from(JPopupMenu menu) {
        return new _MaterialButtonPopup(menu);
    }

    protected _MaterialButtonPopup(JPopupMenu menu) {
        this();
        this.setComponentPopupMenu(menu);
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
