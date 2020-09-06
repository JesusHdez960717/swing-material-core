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
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.border.LineBorder;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DefaultMaterialLineBorder extends LineBorder implements MaterialLineBorder {

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private int borderRadius = 5;
    private float borderThickness = 0;
    private Color color = MaterialColors.GREEN_700;

    public static DefaultMaterialLineBorder from(Color color, float thickness, int borderRadius) {
        return new DefaultMaterialLineBorder(color, thickness, borderRadius);
    }

    public DefaultMaterialLineBorder(Color color, float thickness, int borderRadius) {
        super(color);
        this.borderRadius = borderRadius;
        this.borderThickness = thickness;
        this.color = color;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        g2.setStroke(new BasicStroke(getBorderThickness()));
        g2.setColor(color);
        g2.draw(new RoundRectangle2D.Float(x, y, width - getBorderThickness(), height - getBorderThickness(), borderRadius * 2, borderRadius * 2));
    }

    @Override
    public boolean getRoundedCorners() {
        return borderRadius != 0;
    }

    @Override
    public int getBorderRadius() {
        return borderRadius;
    }

    @Override
    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
        firePropertyChange("borderRadius", 0, borderRadius);
    }

    @Override
    public float getBorderThickness() {
        return this.borderThickness;
    }

    @Override
    public void setBorderThickness(float thickness) {
        this.borderThickness = thickness;
    }

    @Override
    public Color getBorderColor() {
        return this.color;
    }

    @Override
    public void setBorderColor(Color color) {
        this.color = color;
    }

    public static builder builder() {
        return new builder();
    }

    private void firePropertyChange(String borderRadius, int old, int neww) {
        propertyChangeSupport.firePropertyChange(borderRadius, old, neww);
    }

    public static class builder {

        private int borderRadius = 5;
        private float internalThickness = 0;
        private Color color = MaterialColors.GREEN_700;
        public PropertyChangeListener[] listeners = new PropertyChangeListener[0];

        public builder listeners(PropertyChangeListener... listeners) {
            this.listeners = listeners;
            return this;
        }

        public builder borderRadius(int borderRadius) {
            this.borderRadius = borderRadius;
            return this;
        }

        public builder thickness(float internalThickness) {
            this.internalThickness = internalThickness;
            return this;
        }

        public builder color(Color color) {
            this.color = color;
            return this;
        }

        public DefaultMaterialLineBorder build() {
            DefaultMaterialLineBorder border = DefaultMaterialLineBorder.from(color, internalThickness, borderRadius);
            for (PropertyChangeListener listener : listeners) {
                border.addPropertyChangeListener(listener);
            }
            return border;
        }
    }

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
