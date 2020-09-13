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
import com.jhw.swing.material.injection.MaterialSwingInjector;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _MaterialButtonPopup extends _MaterialButton {

    public static MaterialButton from() {
        return MaterialSwingInjector.getImplementation(_MaterialButtonPopup.class);
    }

    private JPopupMenu popup;

    /**
     * Usar _MaterialButtonPopup.from() para proxy y AOP.
     *
     * @deprecated
     */
    @Deprecated
    public _MaterialButtonPopup() {
        personalize();
        addListeners();
    }

    private void personalize() {
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

    @Override
    public JPopupMenu getComponentPopupMenu() {
        return null;
    }

    @Override
    public void setComponentPopupMenu(JPopupMenu popup) {
        this.popup = popup;
    }

    private void showPopup(MouseEvent e) {
        if (popup != null) {
            //middle of component
            int x = (int) ((getSize().getWidth() - popup.getPreferredSize().getWidth()) / 2);

            int y = (int) ((getSize().getHeight() - popup.getPreferredSize().getHeight()) / 2);
            popup.show(this, x, y);
        }
    }
}


/*Otras posiciones donde puede salir el popup
//middle of mouse
Point mousePos = MouseInfo.getPointerInfo().getLocation();

Rectangle screen = Utils.getScreenSize();
int x = (int) (mousePos.getX() - getPreferredSize().getWidth() / 2);
x = Math.max(0, Math.min((int) (screen.getWidth() - getPreferredSize().getWidth()), x));

int y = (int) (mousePos.getY() - getPreferredSize().getWidth() / 2);
y = Math.max(0, Math.min((int) (screen.getHeight() - getPreferredSize().getHeight()), y));
popup.show(this, x, y);
 
//standar
//popup.show(this, e.getX(), e.getY());
 */
