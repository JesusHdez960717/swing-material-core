/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.popup;

import com.jhw.swing.material.components.button._MaterialButton;
import com.jhw.swing.material.effects.Iconable;
import com.jhw.swing.material.injection.Background_Force_Foreground;
import com.jhw.swing.material.injection.Foreground_Force_Icon;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialShadow;
import com.jhw.swing.util.MaterialDrawingUtils;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Action;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class Button extends _MaterialButton {

    public static Button from() {
        return MaterialSwingInjector.getImplementation(Button.class);
    }

    public Button(Action act) {
        this();
        this.setAction(act);
    }

    public Button() {
        if (getIcon() != null) {
            int s = 3 * Math.max(getIcon().getIconWidth(), getIcon().getIconHeight());
            this.setPreferredSize(new Dimension(s, s));
        } else {
            this.setPreferredSize(new Dimension(75, 75));
        }
        this.setBackground(MaterialColors.BLUEGREY_300);
        this.setBorderColor(MaterialColors.BLUEGREY_50);
        this.setBorderThickness(2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        int offset_lr = MaterialShadow.OFFSET_LEFT + MaterialShadow.OFFSET_RIGHT;
        int offset_td = MaterialShadow.OFFSET_TOP + MaterialShadow.OFFSET_BOTTOM;
        int offset_left = MaterialShadow.OFFSET_LEFT;
        int offset_top = MaterialShadow.OFFSET_TOP;

        if (getType() != Type.FLAT && isEnabled()) {
            paintElevation(g2);
        }

        if (getType() == Type.FLAT) {//si es flat quito correcciones de offset
            offset_lr = 0;
            offset_td = 0;
            offset_left = 0;
            offset_top = 0;
        }
        g2.translate(offset_left, offset_top);

        //color de fondo
        if (isEnabled()) {
            g2.setColor(getColorFadeInto());
        } else {
            Color bg = getBackground();
            g2.setColor(new Color(bg.getRed() / 255f, bg.getGreen() / 255f, bg.getBlue() / 255f, 0.6f));
        }
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, getBorderRadius() * 2, getBorderRadius() * 2));

        //borde
        paintBorder(this, g2, 0, 0, (int) (getWidth() - offset_lr + getBorderThickness()), (int) (getHeight() - offset_td + getBorderThickness()));

        //ripple
        if (this.isEnabled()) {//el ripple por debajo de las letras e iconos
            g2.setClip(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, Math.max(getBorderRadius() * 2 - 4, 0), Math.max(getBorderRadius() * 2 - 4, 0)));
            paintRipple(g2);
        }

        //icon
        if (this.getIcon() != null) {
            int xIcon = (int) (getWidth() - getIcon().getIconWidth()) / 2 - offset_lr / 2;
            int yIcon = (int) (getHeight() / 2 - getIcon().getIconHeight() - 5);
            this.getIcon().paintIcon(this, g2, xIcon, yIcon);
        }

        FontMetrics metrics = g2.getFontMetrics(getFont());

        int xText = (int) (getWidth() - metrics.stringWidth(getText())) / 2 - offset_lr / 2;
        int yText = getHeight() / 2 + metrics.getAscent();

        g2.setColor(getForeground());
        g2.setFont(getFont());
        g2.drawString(this.getText(), xText, yText);

        g2.translate(-offset_left, -offset_top);
    }

}
