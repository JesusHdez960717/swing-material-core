/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.effects;

import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.util.MaterialDrawingUtils;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.swing.border.LineBorder;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DefaultMaterialLineBorder extends LineBorder implements MaterialLineBorder, Serializable {

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private int borderRadius;
    private float borderThickness;
    private Color color;
    private Stroke borderStroke;

    public static DefaultMaterialLineBorder from(Color color, float thickness, int borderRadius, Stroke borderStroke) {
        return new DefaultMaterialLineBorder(color, thickness, borderRadius, borderStroke);
    }

    private DefaultMaterialLineBorder(Color color, float thickness, int borderRadius, Stroke borderStroke) {
        super(color);
        this.borderRadius = borderRadius;
        this.borderThickness = thickness;
        this.color = color;
        this.borderStroke = borderStroke;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if (getBorderThickness() < 0.05) {
            return;
        }
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);
        g2.setStroke(getBorderStroke());
        g2.setColor(color);
        if (borderRadius == 0) {
            g2.draw(new Rectangle2D.Float(x, y, width - getBorderThickness(), height - getBorderThickness()));
        } else {
            g2.draw(new RoundRectangle2D.Float(x, y, width - getBorderThickness(), height - getBorderThickness(), borderRadius * 2, borderRadius * 2));
        }
    }

    @Override
    public boolean getRoundedCorners() {
        return borderRadius != 0;
    }

    /**
     * Gets the current border radius of this button.
     *
     * @return the current border radius of this button, in pixels.
     */
    @Override
    public int getBorderRadius() {
        return borderRadius;
    }

    /**
     * Sets the border radius of this button. You can define a custom radius in
     * order to get some rounded corners in your button, making it look like a
     * pill or even a circular action button.
     *
     * @param borderRadius the new border radius of this button, in pixels.
     */
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
        borderStroke = new SerializedStroke(borderThickness);
    }

    @Override
    public Color getBorderColor() {
        return this.color;
    }

    @Override
    public void setBorderColor(Color color) {
        this.color = color;
    }

    @Override
    public Stroke getBorderStroke() {
        return borderStroke;
    }

    @Override
    public void setBorderStroke(Stroke borderStroke) {
        this.borderStroke = borderStroke;
    }

    public static builder builder() {
        return new builder();
    }

    private void firePropertyChange(String borderRadius, int old, int neww) {
        propertyChangeSupport.firePropertyChange(borderRadius, old, neww);
    }

    public static class builder {

        private int borderRadius = 5;
        private float borderThickness = 0;
        private Color color = MaterialColors.GREEN_700;
        private Stroke borderStroke = new SerializedStroke(borderThickness);
        public PropertyChangeListener[] listeners = new PropertyChangeListener[0];

        public builder listeners(PropertyChangeListener... listeners) {
            this.listeners = listeners;
            return this;
        }

        public builder borderRadius(int borderRadius) {
            this.borderRadius = borderRadius;
            return this;
        }

        public builder thickness(float borderThickness) {
            this.borderThickness = borderThickness;
            return this;
        }

        public builder stroke(Stroke borderStroke) {
            this.borderStroke = borderStroke;
            return this;
        }

        public builder color(Color color) {
            this.color = color;
            return this;
        }

        public DefaultMaterialLineBorder build() {
            DefaultMaterialLineBorder border = DefaultMaterialLineBorder.from(color, borderThickness, borderRadius, borderStroke);
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

    private static class SerializedStroke extends BasicStroke implements Serializable {

        public SerializedStroke(float f, int i, int i1, float f1, float[] floats, float f2) {
            super(f, i, i1, f1, floats, f2);
        }

        public SerializedStroke(float f, int i, int i1, float f1) {
            super(f, i, i1, f1);
        }

        public SerializedStroke(float f, int i, int i1) {
            super(f, i, i1);
        }

        public SerializedStroke(float f) {
            super(f);
        }

        public SerializedStroke() {
        }

    }
}
