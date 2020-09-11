package com.jhw.swing.material.components.button;

import com.jhw.swing.material.injection.Foreground_Force_Icon;
import com.jhw.swing.material.injection.Background_Force_Foreground;
import com.jhw.swing.material.effects.Iconable;
import com.jhw.swing.material.standards.*;
import com.jhw.swing.material.effects.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.DefaultMouseAdapterInfo;
import com.jhw.swing.util.*;
import java.beans.PropertyChangeListener;

/**
 * A Material Design button. El orden en que setteen las cosas varia el
 * comportamiento visual del boton. Por ejemplo, al set el background este
 * ajusta el color del ripple a uno que contraste, asi como el foreground. Y el
 * foreground por su parte, ajusta el color del icono el caso de que sea
 * derivable.
 *
 * @see <a
 * href="https://www.google.com/design/spec/components/buttons.html">Buttons
 * (Google design guidelines)</a>
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _MaterialButton extends MaterialButton {

    private final MouseAdapterInfo mouseInfo = DefaultMouseAdapterInfo.from(this);

    private final ColorFadeInto colorFadeInto = new DefaultColorFadeInto(this);

    private final RippleEffect ripple = DefaultRippleEffect.applyTo(this);

    private ElevationEffect elevation = DefaultElevationEffect.applyTo(this, MaterialShadow.ELEVATION_NONE);

    private final MaterialLineBorder border = DefaultMaterialLineBorder.builder().listeners(this).build();

    private Type type = Type.DEFAULT;

    public static _MaterialButton from() {
        return new _MaterialButton();
    }

    /**
     * Creates a new button.
     */
    protected _MaterialButton() {
        this.setIconTextGap(2);
        this.setFont(MaterialFontRoboto.MEDIUM.deriveFont(16f));
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
//-----------------RIPPLE_EFFECT------------------------

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
//-----------------ELEVATION_EFFECT------------------------

    @Override
    public double getLevel() {
        return elevation.getLevel();
    }

    @Override
    public double getElevation() {
        if (isMousePressed()) {
            return MaterialShadow.ELEVATION_HIGHTEST;
        } else if (type == Type.RAISED || isFocusOwner() || isMouseOver()) {
            return MaterialShadow.ELEVATION_DEFAULT;
        } else {
            return MaterialShadow.ELEVATION_NONE;
        }
    }

    @Override
    public void paintElevation(Graphics2D g2) {
        elevation.paintElevation(g2);
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
//------------------------------------------------------------------------------
    //para si extiende uno con elevation round

    protected void setElevation(DefaultElevationEffect elevation) {
        this.elevation = elevation;
        repaint();
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
    }

    @Override
    protected void processFocusEvent(FocusEvent focusEvent) {
        super.processFocusEvent(focusEvent);
        firePropertyChange("processFocusEvent", null, null);
    }

    @Override
    protected void processMouseEvent(MouseEvent mouseEvent) {
        super.processMouseEvent(mouseEvent);
        firePropertyChange("processMouseEvent", null, null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        int offset_lr = MaterialShadow.OFFSET_LEFT + MaterialShadow.OFFSET_RIGHT;
        int offset_td = MaterialShadow.OFFSET_TOP + MaterialShadow.OFFSET_BOTTOM;
        int offset_left = MaterialShadow.OFFSET_LEFT;
        int offset_top = MaterialShadow.OFFSET_TOP;

        if (type != Type.FLAT && isEnabled()) {
            paintElevation(g2);
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
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, getBorderRadius() * 2, getBorderRadius() * 2));

        //borde
        paintBorder(this, g2, 0, 0, (int) (getWidth() - offset_lr + getBorderThickness()), (int) (getHeight() - offset_td + getBorderThickness()));

        //ripple
        if (this.isEnabled()) {//el ripple por debajo de las letras e iconos
            g2.setClip(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, Math.max(getBorderRadius() * 2 - 4, 0), Math.max(getBorderRadius() * 2 - 4, 0)));
            paintRipple(g2);
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
        g2.setColor(fg);
        g2.setFont(getFont());
        g2.drawString(this.getText(), xText, y);

        //icon
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
