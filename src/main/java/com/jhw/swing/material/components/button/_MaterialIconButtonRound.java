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
import com.jhw.swing.material.standards.MaterialIcons;
import javax.swing.Icon;

/**
 * A Material Design button. A round button with a icon in the middle
 *
 * @see <a
 * href="https://www.google.com/design/spec/components/buttons.html">Buttons
 * (Google design guidelines)</a>
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialIconButtonRound extends _MaterialButton implements MaterialComponent {

    public _MaterialIconButtonRound(Icon icon) {
        this();
        this.setIcon(icon);
    }

    /**
     * Creates a new button.
     */
    public _MaterialIconButtonRound() {
        this.setBorderRadius(500);
        this.setText("");

        //icon
        this.setIcon(MaterialIcons.FACE);

        //size
        final int offset_lr = MaterialShadow.OFFSET_LEFT + MaterialShadow.OFFSET_RIGHT;
        final int offset_td = MaterialShadow.OFFSET_TOP + MaterialShadow.OFFSET_BOTTOM;
        this.setPreferredSize(new Dimension(3 * this.getIcon().getIconWidth() + offset_lr, 3 * this.getIcon().getIconHeight() + offset_td));

        setElevation(DefaultElevationEffect.applyCirularTo(this, MaterialShadow.ELEVATION_NONE));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        if (getType() != Type.FLAT && isEnabled()) {
            paintElevation(g2);
        }
        g2.translate(MaterialShadow.OFFSET_LEFT, MaterialShadow.OFFSET_TOP);

        final int offset_lr = MaterialShadow.OFFSET_LEFT + MaterialShadow.OFFSET_RIGHT;
        final int offset_td = MaterialShadow.OFFSET_TOP + MaterialShadow.OFFSET_BOTTOM;
        RectangularShape shape = new java.awt.geom.Ellipse2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td);

        if (isEnabled()) {
            g2.setColor(getColorFadeInto());
            g2.fill(shape);

            g2.setColor(new Color(super.getRippleColor().getRed() / 255f, super.getRippleColor().getBlue() / 255f, super.getRippleColor().getBlue() / 255f, 0.12f));
            if ((getType() == Type.FLAT && isMouseOver()) || isFocusOwner()) {
                g2.fill(shape);
            }
        } else {
            Color bg = getBackground();
            g2.setColor(Utils.applyAlphaMask(bg, 0x66000000));
            g2.fill(shape);
        }

        if (isEnabled()) {//paint ripple efect
            g2.setClip(shape);
            g2.setColor(getRippleColor());
            paintRipple(g2);
        }
        if (getIcon() != null) {
            getIcon().paintIcon(this, g2, (this.getSize().width - offset_lr) / 2 - getIcon().getIconWidth() / 2, (this.getSize().height - offset_td) / 2 - getIcon().getIconHeight() / 2);
        }
        g2.translate(-MaterialShadow.OFFSET_LEFT, -MaterialShadow.OFFSET_TOP);
    }

}
