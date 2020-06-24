package com.jhw.swing.material.components.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.material.effects.RippleEffect;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialIcons;

/**
 * A Material Design icon button. A transparent square button qith a icon in the
 * middle. Don't include border or elevation because it's transparent.
 *
 * @see <a
 * href="https://www.google.com/design/spec/components/buttons.html">Buttons
 * (Google design guidelines)</a>
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialIconButtonTranspRect extends JButton implements MaterialComponent {

    private final RippleEffect ripple = RippleEffect.applyTo(this);
    private Color rippleColor = MaterialColors.WHITE;
    private boolean paintRipple = true;

    /**
     * Creates a new button.
     */
    public _MaterialIconButtonTranspRect() {
        this.setIcon(MaterialIcons.COMPUTER);
        this.setPreferredSize(new Dimension(2 * this.getIcon().getIconWidth(), 2 * this.getIcon().getIconHeight()));
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setOpaque(false);
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public boolean isPaintRipple() {
        return paintRipple;
    }

    public void setPaintRipple(boolean paintRipple) {
        this.paintRipple = paintRipple;
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

    @Override
    public void setIcon(Icon icon) {
        super.setIcon(icon);
        repaint();
    }

    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
        repaint();
    }

    @Override
    protected void processFocusEvent(FocusEvent focusEvent) {
        super.processFocusEvent(focusEvent);
        repaint();
    }

    @Override
    protected void processMouseEvent(MouseEvent mouseEvent) {
        super.processMouseEvent(mouseEvent);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        int distance = 5;
        int xIcon = 0;

        if (getIcon() != null) {
            int align = getHorizontalAlignment();

            if (align == SwingConstants.TRAILING || align == SwingConstants.RIGHT) {
                xIcon = getWidth() - getIcon().getIconWidth() - distance;
            } else if (align == SwingConstants.LEADING || align == SwingConstants.LEFT) {
                xIcon = distance;
            } else {
                xIcon = this.getSize().width / 2 - getIcon().getIconWidth() / 2;
            }
        }

        if (paintRipple) {
            g2.setColor(rippleColor);
            ripple.paint(g2);
        }
        if (!isEnabled()) {
            AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);
            g2.setComposite(ac);
        }
        if (getIcon() != null) {
            getIcon().paintIcon(this, g2, xIcon, this.getSize().height / 2 - getIcon().getIconHeight() / 2);
        }
    }

    @Override
    protected void paintBorder(Graphics g) {
        //intentionally left blank
    }

    @Override
    public _MaterialIconButtonTranspRect clone() {
        _MaterialIconButtonTranspRect other = new _MaterialIconButtonTranspRect();
        for (ActionListener al : this.getActionListeners()) {
            other.addActionListener(al);
        }
        other.setIcon(this.getIcon());
        other.setRippleColor(this.getRippleColor());
        return other;
    }
}
