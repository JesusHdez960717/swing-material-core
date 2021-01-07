/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.effects;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface Wrong {

    public void wrong();

    public void wrong(String wrongText);

    /**
     * Get the wrong color. The worng color is the color of the component when
     * is wrong.
     *
     * @return the wrong color
     */
    public Color getWrongColor();

    /**
     * Set the wrong color. The worng color is the color of the component when
     * is wrong.
     *
     * @param wrongColor the wrong color
     */
    public void setWrongColor(Color wrongColor);

    public void clearWrong();

    public void paintWrong(Graphics g2, int y);
}
