/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textarea;

import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.util.MaterialDrawingUtils;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.LineBorder;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialLineBorder extends LineBorder {

    private int borderRadius = 1;
    private float thickkness = 5;
    private Color color;

    public MaterialLineBorder() {
        this(MaterialColors.GREEN_700, 1, 5);
    }

    public MaterialLineBorder(Color color) {
        this(color, 1, 5);
    }

    public MaterialLineBorder(Color color, float thickkness, int borderRadius) {
        super(color, (int) thickkness);
        this.borderRadius = borderRadius;
        this.thickkness = thickkness;
        this.color = color;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        g2.setStroke(new BasicStroke(thickkness));
        g2.setColor(color);
        g2.draw(new RoundRectangle2D.Float(x, y, width - thickkness, height - thickkness, borderRadius * 2, borderRadius * 2));
    }

    @Override
    public boolean getRoundedCorners() {
        return borderRadius != 0;
    }

    public int getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
    }

    public void setThickkness(float thickkness) {
        this.thickkness = thickkness;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
