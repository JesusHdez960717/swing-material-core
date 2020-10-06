/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.effects;

import com.jhw.module.util.personalization.core.domain.Personalization;
import com.jhw.module.util.personalization.services.PersonalizationHandler;
import java.awt.Color;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JComponent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DefaultWrong implements Wrong, PropertyChangeListener {

    private Color wrongColor = PersonalizationHandler.getColor(Personalization.KEY_COLOR_WRONG);
    private String wrongText = "Error en este campo";
    private boolean wrongFlag = false;

    private Color foregroundOriginal;

    private final JComponent target;

    public DefaultWrong(JComponent target) {
        this.target = target;

        this.foregroundOriginal = target.getForeground();

        target.addPropertyChangeListener(this);
    }

    @Override
    public void paintWrong(Graphics g2, int y) {
        //paint the wrong text if the flag is actived
        if (wrongFlag) {
            g2.setColor(getWrongColor());
            g2.setFont(target.getFont().deriveFont(target.getFont().getSize2D() * 0.8f).deriveFont(1));//1 for bold
            g2.drawString(wrongText, 0, y);//paint the wrong text
        }

    }

    @Override
    public Color getWrongColor() {
        return wrongColor;
    }

    @Override
    public void setWrongColor(Color wrongColor) {
        this.wrongColor = wrongColor;
    }

    @Override
    public void wrong() {
        this.wrongFlag = true;
        this.target.setForeground(wrongColor);
        this.target.repaint();
    }

    @Override
    public void wrong(String wrongText) {
        this.wrongText = wrongText;
        wrong();
    }

    @Override
    public void clearWrong() {
        if (wrongFlag) {
            this.wrongFlag = false;
            this.target.setForeground(foregroundOriginal);
            this.target.repaint();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "foreground":
                Color fg = (Color) evt.getNewValue();
                if (!fg.equals(wrongColor)) {
                    this.foregroundOriginal = fg;
                }
                break;
        }
    }

}
