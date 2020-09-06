package com.jhw.swing.material.components.container.panel;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.material.effects.DefaultElevationEffect;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.material.standards.MaterialShadow;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.components.button._MaterialButton;
import com.jhw.swing.material.effects.ElevationEffect;

/**
 * A JPanel customized for Material components. What makes these panels special
 * is the possibility of assigning them an elevation level. Elevation can help
 * distinguishing elements inside a Material-based GUI, and any changes done to
 * them result in nicely animated transitions, helping to achieve that Material
 * flow.
 * <p/>
 * However, there is a catch: shadows are kinda expensive to compute, as Java2D
 * relies on the CPU for anything other than images, so having a lot of elements
 * with a given elevation (and thus, a shadow) can reduce performance when these
 * elevations change due to the triggered animations.
 * <p/>
 * Letting the components suggest a prefered size based on their contents is
 * still under development, so it is not advised to use your favorite
 * {@link LayoutManager} inside a {@code _MaterialPanel} unless you set the
 * prefered, minimum and maximum size of each component by yourself. Currently,
 * the prefereable approach to follow is overriding {@link #doLayout()} and
 * taking care of any arrangements by yourself.
 */
public class _MaterialPanel extends JPanel implements MaterialComponent, ElevationEffect {

    private final ElevationEffect elevation = DefaultElevationEffect.applyTo(this, MaterialShadow.ELEVATION_DEFAULT);
    private int borderRadius = 5;

    /**
     * Creates a new {@code MaterialPanel}. These panels cast a shadow below
     * them, although technically it is painted inside its borders. If you don't
     * need a shadow to be casted from this panel, use a {@link JPanel} instead.
     */
    public _MaterialPanel() {
        this.setOpaque(false);
        
        this.setBackground(PersonalizationHandler.getColor(Personalization.KEY_COLOR_BACKGROUND_PANEL));

        setBorderRadius(borderRadius);
    }
//-----------------ELEVATION_EFFECT------------------------

    @Override
    public double getLevel() {
        return elevation.getLevel();
    }

    @Override
    public double getElevation() {
        return MaterialShadow.ELEVATION_DEFAULT;
    }

    @Override
    public void paintElevation(Graphics2D g2) {
        elevation.paintElevation(g2);
    }
//-----------------ELEVATION_EFFECT------------------------

    /**
     * Gets the current border radius of this button.
     *
     * @return the current border radius of this button, in pixels.
     */
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
    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
        firePropertyChange("borderRadius", 0, borderRadius);
    }

    /**
     * Sets the background color of this panel. Keep on mind that setting a
     * background color in a Material component like this will also set the
     * foreground color to either white or black, depending of how bright or
     * dark is the chosen background color.
     * <p/>
     * <b>NOTE:</b> It is up to the look and feel to honor this property, some
     * may choose to ignore it. To avoid any conflicts, using the
     * <a
     * href="https://docs.oracle.com/javase/7/docs/api/javax/swing/plaf/metal/package-summary.html">
     * Metal Look and Feel</a> is recommended.
     *
     * @param bg the desired background <code>Color</code>
     */
    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        this.setForeground(Utils.getForegroundAccording(bg));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        paintElevation(g2);
        g2.translate(MaterialShadow.OFFSET_LEFT, MaterialShadow.OFFSET_TOP);

        final int offset_lr = MaterialShadow.OFFSET_LEFT + MaterialShadow.OFFSET_RIGHT;
        final int offset_td = MaterialShadow.OFFSET_TOP + MaterialShadow.OFFSET_BOTTOM;

        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, borderRadius * 2, borderRadius * 2));

        g2.setClip(null);

        g2.translate(-MaterialShadow.OFFSET_LEFT, -MaterialShadow.OFFSET_TOP);
    }
}
