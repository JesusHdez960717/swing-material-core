package com.jhw.swing.material.components.labels;

import com.jhw.swing.material.injection.Background_Force_Foreground;
import com.jhw.swing.material.injection.Foreground_Force_Icon;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.SwingConstants;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.util.Utils;
import static com.jhw.swing.material.standards.Utils.HINT_OPACITY_MASK;


/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _MaterialLabel extends MaterialLabel {

    public static MaterialLabel from() {
        return MaterialSwingInjector.getImplementation(_MaterialLabel.class);
    }

    /**
     * Use _MaterialLabel.from() para proy y AOP
     *
     * @deprecated
     */
    @Deprecated
    public _MaterialLabel() {
        this.setFont(MaterialFontRoboto.MEDIUM.deriveFont(16f));
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
                g2.setColor(Utils.applyAlphaMask(fg, HINT_OPACITY_MASK));
                //g2.setColor(new Color(fg.getRed() / 255f, fg.getGreen() / 255f, fg.getBlue() / 255f, 0.6f));
            }

            int iconWidth = 0;
            int iconHeight = 0;
            int distReal = getIconTextGap();
            if (getIcon() != null) {
                iconWidth = getIcon().getIconWidth();
                iconHeight = getIcon().getIconHeight();
            } else {
                distReal = 0;
            }

            FontMetrics metrics = g.getFontMetrics(getFont());

            int xText = 0;
            int xIcon = 0;

            int strWidth = metrics.stringWidth(getText());
            int horizAlign = getHorizontalAlignment();

            if (horizAlign == SwingConstants.TRAILING || horizAlign == SwingConstants.RIGHT) {
                xText = getWidth() - strWidth;
                xIcon = xText - iconWidth - distReal;
            } else if (horizAlign == SwingConstants.LEADING || horizAlign == SwingConstants.LEFT) {
                xIcon = 0;
                xText = iconWidth + distReal;
            } else {
                xText = (getWidth() - strWidth) / 2 + distReal / 2 + iconWidth / 2;
                xIcon = xText - iconWidth - distReal;
            }

            int strHeight = metrics.getHeight();
            int yText = 0;
            int yIcon = 0;
            int vertAlign = getVerticalAlignment();

            if (vertAlign == SwingConstants.TOP) {
                yText = strHeight;
                yIcon = 0;
            } else if (vertAlign == SwingConstants.BOTTOM) {
                yText = getHeight() - metrics.getAscent() / 2;
                yIcon = getHeight() - iconHeight;
            } else {
                yText = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
                yIcon = getHeight() / 2 - iconHeight / 2;
            }
            g2.drawString(this.getText(), xText, yText);//getText().toUpperCase()

            if (this.getIcon() != null) {
                this.getIcon().paintIcon(this, g2, xIcon, yIcon);
            }
        }
    }

    @Override
    protected void paintBorder(Graphics g) {
        //intentionally left blank
    }

    @Override
    public String getObject() {
        return getText();
    }

    @Override
    public void setObject(String object) {
        setText(object);
    }
}
