package com.jhw.swing.material.components.container.panels;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.interfaces.MaterialComponent;

/**
 * Componente extraido su lógica de edisoncorSX.
 */
public class _PanelGradientTranslucid extends _PanelGradient implements MaterialComponent {

    private float inicial = 0.5f;
    private float superior = 0.9f;
    protected float tran = 0.5f;

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        g2.setComposite(AlphaComposite.getInstance(3, this.tran));
        g2.setPaint(getGradientePaint());
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), getBorderRadius() * 2, getBorderRadius() * 2));
    }

    public float getTran() {
        return this.tran;
    }

    public void setTran(float tran) {
        int i;
        int i2 = 1;
        if (tran >= 0.0f) {
            i = 1;
        } else {
            i = 0;
        }
        if (tran > 1.0f) {
            i2 = 0;
        }
        if ((i2 & i) != 0) {
            this.tran = tran;
            repaint();
        }
    }

    public float getInicial() {
        return this.inicial;
    }

    public void setInicial(float inicial) {
        int i;
        int i2 = 1;
        if (inicial >= 0.0f) {
            i = 1;
        } else {
            i = 0;
        }
        if (inicial > 1.0f) {
            i2 = 0;
        }
        if ((i2 & i) != 0) {
            this.inicial = inicial;
        }
    }

    public float getSuperior() {
        return this.superior;
    }

    public void setSuperior(float superior) {
        int i;
        int i2 = 1;
        if (superior >= 0.0f) {
            i = 1;
        } else {
            i = 0;
        }
        if (superior > 1.0f) {
            i2 = 0;
        }
        if ((i2 & i) != 0) {
            this.superior = superior;
        }
    }
}
