/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.material.components.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import com.root101.swing.util.MaterialDrawingUtils;
import com.root101.swing.material.effects.DefaultRippleEffect;
import com.root101.swing.material.effects.RippleEffect;
import com.root101.swing.material.injection.Background_Force_Foreground;
import com.root101.swing.material.injection.Foreground_Force_Icon;
import com.root101.swing.material.injection.MaterialSwingInjector;
import com.root101.swing.material.standards.MaterialIcons;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.util.Utils;
import javax.swing.plaf.basic.BasicButtonUI;
import static com.root101.swing.material.standards.Utils.HINT_OPACITY_MASK;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
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
