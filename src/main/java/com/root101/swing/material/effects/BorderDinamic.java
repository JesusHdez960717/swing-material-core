/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.effects;

import java.awt.Color;
import javax.swing.JComponent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface BorderDinamic {

    public String getBorderTitle();

    public void setBorderTitle(String title);

    public Color getBorderAccentColor();

    public void setBorderAccentColor(Color accentColor);

    public JComponent getFocusableComponent();

    public JComponent getBordeableComponent();

}
