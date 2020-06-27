package com.jhw.swing.material.components.button;

import com.jhw.swing.util.Utils;
import com.jhw.swing.material.standars.MaterialFontRoboto;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.components.button._MaterialButton;
import com.jhw.swing.material.effects.RippleEffect;
import com.jhw.swing.util.interfaces.MaterialComponent;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.plaf.basic.BasicButtonUI;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.material.effects.ColorFadeInto;
import com.jhw.swing.material.effects.ColorFadeInto.ColorChangeTo;

/**
 * A Material Design button. A simple button without elevation or rounded
 * borders.
 *
 * @see <a
 * href="https://www.google.com/design/spec/components/buttons.html">Buttons
 * (Google design guidelines)</a>
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialButtonSimpleIcon extends _MaterialButton implements MaterialComponent {

    private ColorFadeInto fadeinto;
    private RippleEffect ripple = RippleEffect.applyTo(this);
    private boolean isMouseOver = false;
    private Color rippleColor = Color.WHITE;
    private Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
    private int borderRadius = 0;

    /**
     * Creates a new button.
     */
    public _MaterialButtonSimpleIcon() {
        this.setIcon(MaterialIcons.INSERT_EMOTICON);
        this.setFont(MaterialFontRoboto.MEDIUM.deriveFont(16f));
        this.setCursor(cursor);
        this.setPreferredSize(new Dimension(65, 45));
        this.setFocusable(false);

        this.setOpaque(false);

        this.setBackground(MaterialColors.REDA_200);
        fadeinto = new ColorFadeInto(this, ColorFadeInto.ColorChangeTo.DARKEN);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isMouseOver = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isMouseOver = false;
                repaint();
            }
        });

        this.setUI(new BasicButtonUI());
    }

    public void setColorChangeTo(ColorChangeTo to) {
        fadeinto = new ColorFadeInto(this, to);
    }

    public boolean isMouseOver() {
        return isMouseOver;
    }

    /**
     * Sets the backgroundReal color of this button.
     * <p>
     * Keep on mind that setting a backgroundReal color in a Material component
     * like this will also set the foreground color to either white or black and
     * the ripple color to a brighter or darker shade of the color, depending of
     * how bright or dark is the chosen backgroundReal color. If you want to use
     * a custom foreground color and ripple color, ensure the backgroundReal
     * color has been set first.
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
        fadeinto = new ColorFadeInto(this, ColorFadeInto.ColorChangeTo.DARKEN);
    }

    /**
     * Gets the ripple color.
     *
     * @return the ripple color
     */
    public Color getRippleColor() {
        return rippleColor;
    }

    /**
     * Sets the ripple color. You should only do this for flat buttons.
     *
     * @param rippleColor the ripple color
     */
    public void setRippleColor(Color rippleColor) {
        this.rippleColor = rippleColor;
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
    }

    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
        super.setCursor(b ? cursor : Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void setCursor(Cursor cursor) {
        super.setCursor(cursor);
        this.cursor = cursor;
    }

    @Override
    protected void processFocusEvent(FocusEvent focusEvent) {
        super.processFocusEvent(focusEvent);
        fadeinto.update();
    }

    @Override
    protected void processMouseEvent(MouseEvent mouseEvent) {
        super.processMouseEvent(mouseEvent);
        fadeinto.update();
    }

    public RippleEffect getRippleEffect() {
        return ripple;
    }

    public ColorFadeInto getFadeinto() {
        return fadeinto;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        Color bg = getBackground();
        if (isEnabled()) {
            bg = fadeinto.getColor();
            g2.setColor(bg);

            g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), borderRadius * 2, borderRadius * 2));
            //g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 0, 0)); 

            //g2.setColor(new Color(rippleColor.getRed() / 255f, rippleColor.getBlue() / 255f, rippleColor.getBlue() / 255f, 0.12f)); 
        } else {
            g2.setColor(new Color(bg.getRed() / 255f, bg.getGreen() / 255f, bg.getBlue() / 255f, 0.6f));
            g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 0, 0));
        }

        if (this.isEnabled()) {//el ripple por debajo de las letras e iconos 
            g2.setClip(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 0, 0));
            g2.setColor(rippleColor);
            ripple.paint(g2);
        }

        FontMetrics metrics = g2.getFontMetrics(getFont());
        int x = (getWidth() - metrics.stringWidth(getText())) / 2;
        int y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
        g2.setFont(getFont());
        if (this.isEnabled()) {
            g2.setColor(this.getForeground());
        } else {
            Color fg = this.getForeground();
            g2.setColor(new Color(fg.getRed() / 255f, fg.getGreen() / 255f, fg.getBlue() / 255f, 0.6f));
        }
        g2.drawString(this.getText(), x, y);

        if (getIcon() != null) {
            getIcon().paintIcon(this, g2, (this.getSize().width) / 2 - getIcon().getIconWidth() / 2, (this.getSize().height) / 2 - getIcon().getIconHeight() / 2);
        }

    }

    @Override
    protected void paintBorder(Graphics g) {
        //intentionally left blank 
    }

}
