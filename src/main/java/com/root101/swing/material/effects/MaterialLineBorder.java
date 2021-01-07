/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.effects;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Stroke;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface MaterialLineBorder extends BorderRadius {

    public float getBorderThickness();

    public void setBorderThickness(float thickness);

    public Color getBorderColor();

    public void setBorderColor(Color color);

    public Stroke getBorderStroke();

    public void setBorderStroke(Stroke stroke);

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height);
}
