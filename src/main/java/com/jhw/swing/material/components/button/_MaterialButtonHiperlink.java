package com.jhw.swing.material.components.button;

import com.jhw.swing.material.standards.MaterialColors;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.Utils;
import com.jhw.swing.utils.icons.DerivableIcon;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.material.standards.MaterialIcons;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialButtonHiperlink extends JButton implements MaterialComponent {

    public static _MaterialButtonHiperlink from() {
        return new _MaterialButtonHiperlink();
    }

    private Color mouseEnteredColor = MaterialColors.BLUEA_700;
    private Color mouseExitedColor = MaterialColors.GREENA_700;

    protected _MaterialButtonHiperlink(String text) {
        this();
        this.setText(text);
    }

    public _MaterialButtonHiperlink() {
        mouseExitedColor = (PersonalizationHandler.getColor(Personalization.KEY_COLOR_BUTTON_ADD));
        this.setFont(MaterialFontRoboto.MEDIUM.deriveFont(16f));
        this.setIcon(MaterialIcons.ADD_CIRCLE_OUTLINE);
        this.setCursor(Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        this.setOpaque(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(mouseEnteredColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(mouseExitedColor);
            }
        });
        this.setForeground(mouseExitedColor);
    }

    public Color getMouseEnteredColor() {
        return mouseEnteredColor;
    }

    public void setMouseEnteredColor(Color mouseEnteredColor) {
        this.mouseEnteredColor = mouseEnteredColor;
    }

    public Color getMouseExitedColor() {
        return mouseExitedColor;
    }

    public void setMouseExitedColor(Color mouseExitedColor) {
        this.mouseExitedColor = mouseExitedColor;
    }

    @Override
    public void setIcon(Icon icon) {
        if (icon instanceof DerivableIcon) {
            icon = ((DerivableIcon) icon).deriveIcon(getForeground());
        }
        super.setIcon(icon);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        setForeground(Utils.getForegroundAccording(bg));
    }

    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        setIcon(getIcon());
    }
    /*
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        int iconWidth = 0;
        if (getIcon() != null) {
            iconWidth = getIcon().getIconWidth();
        }

        FontMetrics metrics = g2.getFontMetrics(getFont());
        int y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();

        int xText = 0;
        int xIcon = 0;
        int widthReal = getWidth();
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
            this.getIcon().paintIcon(this, g2, xIcon, (getHeight() - getIcon().getIconHeight()) / 2);
        }

    }

    @Override
    protected void paintBorder(Graphics g) {
        //intentionally left blank
    }
     */
}
