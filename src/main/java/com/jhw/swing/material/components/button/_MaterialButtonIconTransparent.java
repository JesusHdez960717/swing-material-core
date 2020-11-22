package com.jhw.swing.material.components.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.material.effects.DefaultRippleEffect;
import com.jhw.swing.material.effects.RippleEffect;
import com.jhw.swing.material.injection.Background_Force_Foreground;
import com.jhw.swing.material.injection.Foreground_Force_Icon;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.util.Utils;
import javax.swing.plaf.basic.BasicButtonUI;
import static com.jhw.swing.material.standards.Utils.HINT_OPACITY_MASK;

@Background_Force_Foreground
@Foreground_Force_Icon
public class _MaterialButtonIconTransparent extends MaterialButtonIcon {

    public static final String KEY_ACTION_POPUP = "popup";

    private final RippleEffect ripple = DefaultRippleEffect.applyFixedTo(this);

    public static MaterialButtonIcon from() {
        return MaterialSwingInjector.getImplementation(_MaterialButtonIconTransparent.class);
    }

    /**
     * Usar _MaterialButtonIconTransparent.from() para proxy y AOP
     *
     * @deprecated
     */
    @Deprecated
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

        setForeground(MaterialColors.BLACK);
    }
    private Color foregroundOriginalColor;

    @Override
    public void setForeground(Color fg) {
        foregroundOriginalColor = fg;
        super.setForeground(fg);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (enabled) {
            this.setForeground(foregroundOriginalColor);
        } else {
            this.setForeground(Utils.applyAlphaMask(foregroundOriginalColor, HINT_OPACITY_MASK));
        }
    }

    @Override
    public void setAction(Action a) {
        super.setAction(a);
        this.setText("");//le quito el texto no vaya a ser muy grande
        this.setToolTipText(a.getValue(Action.NAME).toString());//se lo pongo como tooltip
        this.setComponentPopupMenu((JPopupMenu) a.getValue(KEY_ACTION_POPUP));
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
        this.ripple.setPaintRipple(paintRipple);
    }

    /**
     * Gets the ripple color.
     *
     * @return the ripple color
     */
    @Override
    public Color getRippleColor() {
        return ripple.getRippleColor();
    }

    /**
     * Sets the ripple color. You should only do this for flat buttons.
     *
     * @param rippleColor the ripple color
     */
    @Override
    public void setRippleColor(Color rippleColor) {
        this.ripple.setRippleColor(rippleColor);
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

        int xIcon = 0;

        if (getIcon() != null) {
            int align = getHorizontalAlignment();

            if (align == SwingConstants.TRAILING || align == SwingConstants.RIGHT) {
                xIcon = getWidth() - getIcon().getIconWidth() - getIconTextGap();
            } else if (align == SwingConstants.LEADING || align == SwingConstants.LEFT) {
                xIcon = getIconTextGap();
            } else {
                xIcon = this.getSize().width / 2 - getIcon().getIconWidth() / 2;
            }
        }

        if (isEnabled()) {
            paintRipple(g2);
        }

        if (getIcon() != null) {
            getIcon().paintIcon(this, g2, xIcon, this.getSize().height / 2 - getIcon().getIconHeight() / 2);
        }
    }

    @Override
    protected void paintBorder(Graphics g) {
        //intentionally left blank
    }

}
