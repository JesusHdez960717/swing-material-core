package com.jhw.swing.material.components.button;

import com.jhw.swing.material.effects.ColorFadeInto;
import com.jhw.swing.material.effects.DefaultColorFadeInto;
import com.jhw.swing.util.Utils;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.material.standards.MaterialShadow;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.effects.DefaultElevationEffect;
import com.jhw.swing.material.effects.DefaultRippleEffect;
import com.jhw.swing.util.interfaces.MaterialComponent;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.DefaultMouseAdapterInfo;
import com.jhw.swing.utils.icons.DerivableIcon;
import javax.swing.border.EmptyBorder;
import com.jhw.swing.util.*;

/**
 * A Material Design button.
 *
 * @see <a
 * href="https://www.google.com/design/spec/components/buttons.html">Buttons
 * (Google design guidelines)</a>
 */
public class _MaterialButton extends JButton implements ColorFadeInto, MouseAdapterInfo, MaterialComponent {

    private MouseAdapterInfo mouseInfo = DefaultMouseAdapterInfo.from(this);

    private ColorFadeInto colorFadeInto = new DefaultColorFadeInto(this);

    private DefaultRippleEffect ripple = DefaultRippleEffect.applyTo(this);
    private DefaultElevationEffect elevation = DefaultElevationEffect.applyTo(this, MaterialShadow.ELEVATION_NONE);
    private Type type = Type.DEFAULT;
    private Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
    private int borderRadius = 5;

    private Color borderColor = MaterialColors.BLACK;
    private int borderThickness = 0;

    /**
     * Creates a new button.
     */
    public _MaterialButton() {
        this.setIconTextGap(2);
        this.setFont(MaterialFontRoboto.MEDIUM.deriveFont(16f));
        this.setCursor(cursor);
        this.setPreferredSize(new Dimension(145, 65));
        this.setFocusable(false);

        this.setOpaque(false);

        this.setBackground(MaterialColors.RED_500);

        this.setUI(new BasicButtonUI() {
            @Override
            public boolean contains(JComponent c, int x, int y) {
                if (type == Type.FLAT) {
                    return super.contains(c, x, y);
                }
                return x > MaterialShadow.OFFSET_LEFT && y > MaterialShadow.OFFSET_TOP
                        && x < getWidth() - MaterialShadow.OFFSET_RIGHT && y < getHeight() - MaterialShadow.OFFSET_BOTTOM;
            }
        });
    }
//-----------------COLOR_FADE_INTO------------------------

    @Override
    public Color getColorFadeInto() {
        return colorFadeInto.getColorFadeInto();
    }

    @Override
    public Color getAccentColorFadeInto() {
        return colorFadeInto.getAccentColorFadeInto();
    }

    @Override
    public void setAccentColorFadeInto(Color color) {
        colorFadeInto.setAccentColorFadeInto(color);
    }

//-----------------MOUSE_ADAPTER_INFO------------------------
    @Override
    public boolean isMousePressed() {
        return mouseInfo.isMousePressed();
    }

    @Override
    public boolean isMouseOver() {
        return mouseInfo.isMouseOver();
    }
//-----------------MOUSE_ADAPTER_INFO------------------------

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getBorderThickness() {
        return borderThickness;
    }

    public void setBorderThickness(int borderThickness) {
        this.borderThickness = borderThickness;
    }

    public void setElevation(DefaultElevationEffect elevation) {
        this.elevation = elevation;
        repaint();
    }

    @Override
    public void setIcon(Icon icon) {
        if (icon instanceof DerivableIcon) {
            icon = ((DerivableIcon) icon).deriveIcon(getForeground());
        }
        super.setIcon(icon);
    }

    /**
     * Gets the ripple color.
     *
     * @return the ripple color
     */
    public Color getRippleColor() {
        return ripple.getRippleColor();
    }

    /**
     * Sets the ripple color. You should only do this for flat buttons.
     *
     * @param rippleColor the ripple color
     */
    public void setRippleColor(Color rippleColor) {
        if (this.ripple != null) {
            this.ripple.setRippleColor(rippleColor);
        }
    }

    /**
     * Gets the type of this button.
     *
     * @return the type of this button
     * @see Type
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the type of this button.
     *
     * @param type the type of this button
     * @see Type
     */
    public void setType(Type type) {
        this.type = type;
        setEnabled(true);//para que pinte la sombra
        repaint();
    }

    /**
     * Sets the Background color of this button.
     * <p>
     * Keep on mind that setting a background color in a Material component like
     * this will also set the foreground color to either white or black and the
     * ripple color to white or darker shade of the color, depending of how
     * bright or dark is the chosen backgroundReal color. If you want to use a
     * custom foreground color and ripple color, ensure the background color has
     * been set first.
     * <p>
     * <b>NOTE:</b> It is up to the look and feel to honor this property, some
     * may choose to ignore it. To avoid any conflicts, using the
     * <a
     * href="https://docs.oracle.com/javase/7/docs/api/javax/swing/plaf/metal/package-summary.html">
     * Metal Look and Feel</a> is recommended.
     */
    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        setForeground(Utils.getForegroundAccording(bg));
        setRippleColor(Utils.getForegroundAccording(bg));
    }

    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        setIcon(getIcon());
    }

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
        elevation.setBorderRadius(borderRadius);
    }

    /**
     * Set the button enable. Include changing the elevation and the curson
     * according.
     *
     * @param b Boolean whit the enability.
     */
    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
        elevation.setLevel(getElevation());
        super.setCursor(b ? cursor : Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    /**
     * Set the cursor of the component.
     *
     * @param cursor Cursor of the component.
     */
    @Override
    public void setCursor(Cursor cursor) {
        super.setCursor(cursor);
        this.cursor = cursor;
    }

    @Override
    protected void processFocusEvent(FocusEvent focusEvent) {
        super.processFocusEvent(focusEvent);
        firePropertyChange("processFocusEvent", null, null);
        elevation.setLevel(getElevation());
    }

    @Override
    protected void processMouseEvent(MouseEvent mouseEvent) {
        super.processMouseEvent(mouseEvent);
        firePropertyChange("processMouseEvent", null, null);
        elevation.setLevel(getElevation());
    }

    protected DefaultElevationEffect getElevationEffect() {
        return elevation;
    }

    public DefaultRippleEffect getRippleEffect() {
        return ripple;
    }

    protected double getElevation() {
        if (isMousePressed()) {
            return MaterialShadow.ELEVATION_HIGHTEST;
        } else if (type == Type.RAISED || isFocusOwner() || isMouseOver()) {
            return MaterialShadow.ELEVATION_DEFAULT;
        } else {
            return MaterialShadow.ELEVATION_NONE;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        int offset_lr = MaterialShadow.OFFSET_LEFT + MaterialShadow.OFFSET_RIGHT;
        int offset_td = MaterialShadow.OFFSET_TOP + MaterialShadow.OFFSET_BOTTOM;
        int offset_left = MaterialShadow.OFFSET_LEFT;
        int offset_top = MaterialShadow.OFFSET_TOP;

        if (type != Type.FLAT && isEnabled()) {
            elevation.paint(g2);
        }

        if (type == Type.FLAT) {//si es flat quito correcciones de offset
            offset_lr = 0;
            offset_td = 0;
            offset_left = 0;
            offset_top = 0;
        }
        g2.translate(offset_left, offset_top);

        //color de fondo
        if (isEnabled()) {
            g2.setColor(getColorFadeInto());
        } else {
            Color bg = getBackground();
            g2.setColor(new Color(bg.getRed() / 255f, bg.getGreen() / 255f, bg.getBlue() / 255f, 0.6f));
        }
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, borderRadius * 2, borderRadius * 2));

        if (getBorderThickness() > 0) {//si hay border lo pinto
            //g2.setStroke(new BasicStroke(getBorderThickness(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
            g2.setStroke(new BasicStroke(getBorderThickness()));
            g2.setColor(getBorderColor());
            g2.draw(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, borderRadius * 2, borderRadius * 2));
        }

        if (this.isEnabled()) {//el ripple por debajo de las letras e iconos
            g2.setClip(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, Math.max(borderRadius * 2 - 4, 0), Math.max(borderRadius * 2 - 4, 0)));
            ripple.paint(g2);
        }

        int iconWidth = 0;
        if (getIcon() != null) {
            iconWidth = getIcon().getIconWidth();
        }

        FontMetrics metrics = g2.getFontMetrics(getFont());
        int y = (getHeight() - offset_td - metrics.getHeight()) / 2 + metrics.getAscent();

        int xText = 0;
        int xIcon = 0;
        int widthReal = getWidth() - offset_lr;
        int strWidth = metrics.stringWidth(getText());
        int align = getHorizontalAlignment();

        if (align == SwingConstants.TRAILING || align == SwingConstants.RIGHT) {
            xText = widthReal - strWidth - 2 * getIconTextGap();
            xIcon = xText - iconWidth - 2 * getIconTextGap();
        } else if (align == SwingConstants.LEADING || align == SwingConstants.LEFT) {
            xIcon = getIconTextGap();
            xText = iconWidth + getIconTextGap();
        } else {
            xText = (widthReal - strWidth) / 2 + getIconTextGap() / 2 + iconWidth / 2;
            xIcon = xText - iconWidth - getIconTextGap();
        }

        Color fg = this.getForeground();
        if (!this.isEnabled()) {
            g2.setColor(new Color(fg.getRed() / 255f, fg.getGreen() / 255f, fg.getBlue() / 255f, 0.6f));
        }
        g2.setColor(fg);
        g2.setFont(getFont());
        g2.drawString(this.getText(), xText, y);

        if (this.getIcon() != null) {
            this.getIcon().paintIcon(this, g2, xIcon, (getHeight() - offset_td - getIcon().getIconHeight()) / 2);
        }
        g2.translate(-offset_left, -offset_top);
    }

    @Override
    protected void paintBorder(Graphics g) {
        //intentionally left blank
    }

    /**
     * Button types.
     */
    public enum Type {

        /**
         * A default button.
         */
        DEFAULT,
        /**
         * A raised button. Raised buttons have a shadow even if they are not
         * focused.
         */
        RAISED,
        /**
         * A flat button. Flat buttons don't have shadows and are typically
         * transparent.
         */
        FLAT
    }
}
