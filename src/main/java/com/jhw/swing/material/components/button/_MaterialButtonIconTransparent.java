package com.jhw.swing.material.components.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.material.effects.DefaultRippleEffect;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.utils.icons.DerivableIcon;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 * A Material Design icon button. A transparent square button qith a icon in the
 * middle. Don't include border or elevation because it's transparent.
 *
 * @see <a
 * href="https://www.google.com/design/spec/components/buttons.html">Buttons
 * (Google design guidelines)</a>
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialButtonIconTransparent extends JButton implements MaterialComponent {

    public static final String KEY_ACTION_POPUP = "popup";

    private final DefaultRippleEffect ripple = DefaultRippleEffect.applyFixedTo(this);
    private Color rippleColor = MaterialColors.WHITE;
    private boolean paintRipple = true;

    public _MaterialButtonIconTransparent(ImageIcon icon) {
        this();
        setIcon(icon);
    }

    /**
     * Creates a new button.
     */
    public _MaterialButtonIconTransparent() {
        this.setIcon(MaterialIcons.COMPUTER);
        this.setPreferredSize(new Dimension(2 * this.getIcon().getIconWidth(), 2 * this.getIcon().getIconHeight()));
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setOpaque(false);
        this.setHorizontalAlignment(SwingConstants.CENTER);

        this.setUI(new BasicButtonUI() {
            @Override
            public boolean contains(JComponent c, int x, int y) {
                int x1 = c.getWidth() / 2;
                int y1 = c.getHeight() / 2;
                int radius = Math.min(c.getWidth(), c.getHeight()) / 2;
                if (x1 - y1 <= 1) {
                    double dist = Math.sqrt(Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2));
                    return dist <= radius;
                } else {
                    return super.contains(c, x, y);
                }
            }
        });
    }

    @Override
    public void setAction(Action a) {
        super.setAction(a);
        this.setText("");//le quito el texto no vaya a ser muy grnade
        this.setToolTipText(a.getValue(Action.NAME).toString());//se lo pongo como tooltip
        this.setComponentPopupMenu((JPopupMenu) a.getValue(KEY_ACTION_POPUP));
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
    public void setForeground(Color fg) {
        super.setForeground(fg);
        setIcon(getIcon());
    }

    @Override
    public void setIcon(Icon icon) {
        if (icon instanceof DerivableIcon) {
            icon = ((DerivableIcon) icon).deriveIcon(getForeground());
        }
        super.setIcon(icon);
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

        if (paintRipple && isEnabled()) {
            g2.setColor(rippleColor);
            ripple.paintRipple(g2);
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
    public _MaterialButtonIconTransparent clone() {
        _MaterialButtonIconTransparent other = new _MaterialButtonIconTransparent();
        for (ActionListener al : this.getActionListeners()) {
            other.addActionListener(al);
        }
        other.setIcon(this.getIcon());
        other.setRippleColor(this.getRippleColor());
        return other;
    }
}
