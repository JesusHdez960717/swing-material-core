package com.jhw.swing.material.components.container.panel;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.material.effects.DefaultElevationEffect;
import com.jhw.swing.material.standards.MaterialShadow;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.effects.DefaultMaterialLineBorder;
import com.jhw.swing.material.effects.MaterialLineBorder;
import com.jhw.swing.material.effects.ElevationEffect;
import com.jhw.swing.material.injection.Background_Force_Foreground;
import com.jhw.swing.material.injection.Foreground_Force_Icon;

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
@Background_Force_Foreground
@Foreground_Force_Icon
public class _MaterialPanel extends MaterialPanelBorder implements ElevationEffect {

    public static _MaterialPanel from() {
        return new _MaterialPanel();
    }

    private final ElevationEffect elevation = DefaultElevationEffect.applyTo(this, MaterialShadow.ELEVATION_DEFAULT);

    private final MaterialLineBorder border = DefaultMaterialLineBorder.builder().borderRadius(5).listeners(this).build();

    private double elevationLevel = MaterialShadow.ELEVATION_DEFAULT;

    private Icon icon;

    /**
     * Creates a new {@code MaterialPanel}. These panels cast a shadow below
     * them, although technically it is painted inside its borders. If you don't
     * need a shadow to be casted from this panel, use a {@link JPanel} instead.
     */
    protected _MaterialPanel() {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.setBackground(PersonalizationHandler.getColor(Personalization.KEY_COLOR_BACKGROUND_PANEL));
    }
//-----------------ELEVATION_EFFECT------------------------

    @Override
    public double getLevel() {
        return elevation.getLevel();
    }

    @Override
    public double getElevation() {
        return elevationLevel;
    }

    @Override
    public void paintElevation(Graphics2D g2) {
        elevation.paintElevation(g2);
    }

    public void setElevationLevel(double elevationLevel) {
        this.elevationLevel = elevationLevel;
    }
//-----------------LINE_BORDER------------------------

    @Override
    public float getBorderThickness() {
        return border.getBorderThickness();
    }

    @Override
    public void setBorderThickness(float thickness) {
        border.setBorderThickness(thickness);
    }

    @Override
    public Color getBorderColor() {
        return border.getBorderColor();
    }

    @Override
    public void setBorderColor(Color color) {
        border.setBorderColor(color);
    }

    @Override
    public int getBorderRadius() {
        return border.getBorderRadius();
    }

    @Override
    public void setBorderRadius(int borderRadius) {
        this.border.setBorderRadius(borderRadius);
        this.elevation.setBorderRadius(borderRadius);
    }

    @Override
    public Stroke getBorderStroke() {
        return border.getBorderStroke();
    }

    @Override
    public void setBorderStroke(Stroke stroke) {
        border.setBorderStroke(stroke);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        border.paintBorder(c, g, x, y, width, height);
    }
//-----------------LINE_BORDER------------------------

    @Override
    public Icon getIcon() {
        return this.icon;
    }

    @Override
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        paintElevation(g2);
        g2.translate(MaterialShadow.OFFSET_LEFT, MaterialShadow.OFFSET_TOP);

        final int offset_lr = MaterialShadow.OFFSET_LEFT + MaterialShadow.OFFSET_RIGHT;
        final int offset_td = MaterialShadow.OFFSET_TOP + MaterialShadow.OFFSET_BOTTOM;

        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, getBorderRadius() * 2, getBorderRadius() * 2));

        g2.setClip(null);

        paintBorder(this, g2, 0, 0, (int) (getWidth() - offset_lr + getBorderThickness()), (int) (getHeight() - offset_td + getBorderThickness()));
        
        if (this.icon != null) {
            if (icon instanceof ImageIcon) {//si es image icon lo pinto completo de todo el tamanno
                g2.drawImage(((ImageIcon) this.icon).getImage(), 0, 0, getWidth() - offset_lr, getHeight() - offset_td, null);
            } else {//si no lo pinto como un simple icon
                icon.paintIcon(this, g2, (getWidth() - icon.getIconWidth()) / 2, (getHeight() - icon.getIconHeight()) / 2);
            }
        }

        g2.translate(-MaterialShadow.OFFSET_LEFT, -MaterialShadow.OFFSET_TOP);
    }

}
