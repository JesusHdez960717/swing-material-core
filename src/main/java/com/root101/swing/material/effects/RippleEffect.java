/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.effects;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface RippleEffect {

    public Color getRippleColor();

    public void setRippleColor(Color color);

    public void paintRipple(Graphics2D g2);

    public boolean getPaintRipple();

    public void setPaintRipple(boolean paintRipple);
}
