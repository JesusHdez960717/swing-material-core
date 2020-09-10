package com.jhw.swing.material.components.container.panel;

import com.jhw.swing.material.injection.Background_Force_Foreground;
import com.jhw.swing.material.injection.Foreground_Force_Icon;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.interfaces.MaterialComponent;

/**
 * Componente extraido su logica de edisoncorSX.
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _PanelGradientTranslucid extends _PanelGradient implements MaterialComponent {

    public static _PanelGradientTranslucid from() {
        return new _PanelGradientTranslucid();
    }

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

}
