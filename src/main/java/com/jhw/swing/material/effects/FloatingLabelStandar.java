package com.jhw.swing.material.effects;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface FloatingLabelStandar {

    public Color getForeground();

    public Font getFont();

    public Dimension getSize();

    public Dimension getPreferredSize();

    public FontMetrics getFontMetrics(Font font);

    public boolean isFocusOwner();

    public String getText();

    public String getFrontText();

    public int getDistanceFrontText();

    public Component getComponent();
}
