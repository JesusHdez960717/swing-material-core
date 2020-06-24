package com.jhw.swing.material.components.labels;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.StringFormating;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.icons.DerivableIcon;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.material.standars.MaterialFontRoboto;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialLabel extends JLabel implements MaterialComponent {

    public static final int DISTANCE_ICON_TEXT = 3;

    public _MaterialLabel() {
        this.setFont(MaterialFontRoboto.MEDIUM.deriveFont(16f));
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        setForeground(Utils.getForegroundAccording(bg));
    }

    public void setIcon(ImageIcon icon) {
        if (icon instanceof DerivableIcon) {
            icon = ((DerivableIcon) icon).deriveIcon(getForeground());
        }
        super.setIcon(icon);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        if (getText().trim().isEmpty() && getIcon() != null) {//solo pinto icono

            this.getIcon().paintIcon(this, g2, (this.getSize().width) / 2 - getIcon().getIconWidth() / 2, (this.getSize().height) / 2 - getIcon().getIconHeight() / 2);

        } else {//pinto todo
            g2.setFont(getFont());
            if (this.isEnabled()) {
                g2.setColor(this.getForeground());
            } else {
                Color fg = this.getForeground();
                g2.setColor(new Color(fg.getRed() / 255f, fg.getGreen() / 255f, fg.getBlue() / 255f, 0.6f));
            }

            int iconWidth = 0;
            int distReal = this.DISTANCE_ICON_TEXT;
            if (getIcon() != null) {
                iconWidth = getIcon().getIconWidth();
            } else {
                distReal = 0;
            }

            FontMetrics metrics = g.getFontMetrics(getFont());
            int y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();

            int xText = 0;
            int xIcon = 0;

            int strWidth = metrics.stringWidth(getText());
            int align = getHorizontalAlignment();

            if (align == SwingConstants.TRAILING || align == SwingConstants.RIGHT) {
                xText = getWidth() - strWidth;
                xIcon = xText - iconWidth - 2 * distReal;
            } else if (align == SwingConstants.LEADING || align == SwingConstants.LEFT) {
                xIcon = distReal;
                xText = iconWidth + distReal;
            } else {
                xText = (getWidth() - strWidth) / 2 + distReal / 2 + iconWidth / 2;
                xIcon = xText - iconWidth - distReal;
            }
            g2.drawString(this.getText(), xText, y);//getText().toUpperCase()

            if (this.getIcon() != null) {
                this.getIcon().paintIcon(this, g2, xIcon, (this.getSize().height) / 2 - getIcon().getIconHeight() / 2);
            }
        }
    }

    @Override
    protected void paintBorder(Graphics g) {
        //intentionally left blank
    }

    public void setMoney(double value, String coin) {
        setText("$ " + StringFormating.formatToMoney(value) + " " + coin);
    }
}
