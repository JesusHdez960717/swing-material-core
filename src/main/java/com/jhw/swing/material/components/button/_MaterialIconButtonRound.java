package com.jhw.swing.material.components.button;

import com.jhw.swing.material.components.button._MaterialButton;
import java.awt.*;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.material.standards.MaterialShadow;
import com.jhw.swing.util.Utils;
import com.jhw.swing.material.effects.DefaultElevationEffect;
import com.jhw.swing.material.effects.DefaultRippleEffect;
import com.jhw.swing.material.effects.RippleEffect;
import com.jhw.swing.material.standards.MaterialIcons;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 * A Material Design button. A round button with a icon in the middle
 *
 * @see <a
 * href="https://www.google.com/design/spec/components/buttons.html">Buttons
 * (Google design guidelines)</a>
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialIconButtonRound extends _MaterialButton implements MaterialComponent {

    public static _MaterialIconButtonRound from(Icon icon) {
        return new _MaterialIconButtonRound(icon);
    }

    public static _MaterialIconButtonRound from() {
        return new _MaterialIconButtonRound();
    }
    private final RippleEffect ripple = DefaultRippleEffect.applyFixedTo(this);

    private boolean circle = true;

    protected _MaterialIconButtonRound(Icon icon) {
        this();
        this.setIcon(icon);
    }

    /**
     * Creates a new button.
     */
    protected _MaterialIconButtonRound() {
        this.setText("");

        //icon
        this.setIcon(MaterialIcons.FACE);

        //size
        final int offset_lr = MaterialShadow.OFFSET_LEFT + MaterialShadow.OFFSET_RIGHT;
        final int offset_td = MaterialShadow.OFFSET_TOP + MaterialShadow.OFFSET_BOTTOM;
        this.setPreferredSize(new Dimension(3 * this.getIcon().getIconWidth() + offset_lr, 3 * this.getIcon().getIconHeight() + offset_td));

        setElevation(DefaultElevationEffect.applyCirularTo(this, MaterialShadow.ELEVATION_NONE));

        this.setUI(new BasicButtonUI() {
            @Override
            public boolean contains(JComponent c, int x, int y) {
                return getShape().contains(x - MaterialShadow.OFFSET_LEFT, y - MaterialShadow.OFFSET_TOP);
            }
        });
    }

    public boolean isCircle() {
        return circle;
    }

    public void setCircle(boolean circle) {
        this.circle = circle;
    }

    @Override
    public Color getRippleColor() {
        return ripple.getRippleColor();
    }

    @Override
    public void setRippleColor(Color color) {
        ripple.setRippleColor(color);
    }

    @Override
    public void paintRipple(Graphics2D g2) {
        ripple.paintRipple(g2);
    }

    @Override
    public boolean getPaintRipple() {
        return ripple.getPaintRipple();
    }

    @Override
    public void setPaintRipple(boolean paintRipple) {
        ripple.setPaintRipple(paintRipple);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        final int offset_lr = MaterialShadow.OFFSET_LEFT + MaterialShadow.OFFSET_RIGHT;
        final int offset_td = MaterialShadow.OFFSET_TOP + MaterialShadow.OFFSET_BOTTOM;

        if (getType() != Type.FLAT && isEnabled()) {
            paintElevation(g2);
        }
        g2.translate(MaterialShadow.OFFSET_LEFT, MaterialShadow.OFFSET_TOP);

        Shape shape = getShape();
        //color de fondo
        if (isEnabled()) {
            g2.setColor(getColorFadeInto());
        } else {
            Color bg = getBackground();
            g2.setColor(new Color(bg.getRed() / 255f, bg.getGreen() / 255f, bg.getBlue() / 255f, 0.6f));
        }
        g2.fill(shape);

        //ripple
        if (this.isEnabled()) {//el ripple por debajo de las letras e iconos
            g2.setClip(shape);
            
            //enderezo la traslacion para el ripple
            g2.translate(-MaterialShadow.OFFSET_LEFT, -MaterialShadow.OFFSET_TOP);
            paintRipple(g2);
            
            //la vuelvo a correr para el icon
            g2.translate(MaterialShadow.OFFSET_LEFT, MaterialShadow.OFFSET_TOP);

        }

        if (getIcon() != null) {
            getIcon().paintIcon(this, g2, (this.getSize().width - offset_lr) / 2 - getIcon().getIconWidth() / 2, (this.getSize().height - offset_td) / 2 - getIcon().getIconHeight() / 2);
        }
        g2.translate(-MaterialShadow.OFFSET_LEFT, -MaterialShadow.OFFSET_TOP);
    }

    private Shape getShape() {
        final int offset_lr = MaterialShadow.OFFSET_LEFT + MaterialShadow.OFFSET_RIGHT;
        final int offset_td = MaterialShadow.OFFSET_TOP + MaterialShadow.OFFSET_BOTTOM;

        int w = getWidth();
        int h = getHeight();
        int x = 0;
        int y = 0;

        if (isCircle()) {
            w = h = Math.min(w, h);
            x = (getWidth() - w) / 2;
            y = (getHeight() - h) / 2;
        }
        return new java.awt.geom.Ellipse2D.Float(x, y, w - offset_lr, h - offset_td);
    }

}
