package com.jhw.swing.material.components.button;

import com.jhw.swing.material.standards.MaterialColors;
import java.awt.Color;
import javax.swing.JButton;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.effects.Iconable;
import com.jhw.swing.material.injection.Background_Force_Foreground;
import com.jhw.swing.material.injection.Foreground_Force_Icon;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.material.standards.MaterialIcons;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _MaterialButtonHiperlink extends JButton implements Iconable, MaterialComponent {

    public static _MaterialButtonHiperlink from() {
        return MaterialSwingInjector.getImplementation(_MaterialButtonHiperlink.class);
        //return new _MaterialButtonHiperlink();
    }

    private Color mouseEnteredColor = MaterialColors.BLUEA_700;
    private Color mouseExitedColor = MaterialColors.GREENA_700;

    /**
     * Usar _MaterialButtonHiperlink.from() para que coja proxy y AOP.
     *
     * @deprecated
     */
    @Deprecated
    public _MaterialButtonHiperlink() {
        mouseExitedColor = (PersonalizationHandler.getColor(Personalization.KEY_COLOR_BUTTON_ADD));
        this.setFont(MaterialFontRoboto.MEDIUM.deriveFont(16f));
        this.setIcon(MaterialIcons.ADD_CIRCLE_OUTLINE);
        this.setCursor(Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        this.setOpaque(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(mouseEnteredColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(mouseExitedColor);
            }
        });
        this.setForeground(mouseExitedColor);
    }

    public Color getMouseEnteredColor() {
        return mouseEnteredColor;
    }

    public void setMouseEnteredColor(Color mouseEnteredColor) {
        this.mouseEnteredColor = mouseEnteredColor;
    }

    public Color getMouseExitedColor() {
        return mouseExitedColor;
    }

    public void setMouseExitedColor(Color mouseExitedColor) {
        this.mouseExitedColor = mouseExitedColor;
    }

}
