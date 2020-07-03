package com.jhw.swing.notification.toast.types.notification;

import com.jhw.swing.notification.toast.ToastComponent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;


import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.Utils;
import com.jhw.swing.material.effects.ElevationEffect;
import com.jhw.swing.util.icons.DerivableIcon;
import com.jhw.swing.material.standars.MaterialFontRoboto;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.material.standars.MaterialShadow;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class NotificationToast extends ToastComponent {

    private final ElevationEffect elevation;

    private int borderRadius = 5;

    private String header = "";

    private Font headerFont = MaterialFontRoboto.BOLD.deriveFont(18f);

    private String text = "";

    private Font textFont = MaterialFontRoboto.BOLD.deriveFont(16f);

    private ImageIcon icon = MaterialIcons.SENTIMENT_VERY_DISSATISFIED;

    private Dimension textDim;

    private Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

    public NotificationToast(ImageIcon icon, String header, Font headerFont, String text, Font textFont, Color background) {
        super.setCursor(cursor);
        elevation = ElevationEffect.applyTo(this, MaterialShadow.ELEVATION_DEFAULT);
        elevation.setBorderRadius(borderRadius);

        this.setBackground(background);

        setIcon(icon);

        this.headerFont = headerFont;
        this.textFont = textFont;
        setText(text);
        setHeader(text);
    }

    public NotificationToast(String text, ImageIcon icon, Color color) {
        super.setCursor(cursor);
        elevation = ElevationEffect.applyTo(this, MaterialShadow.ELEVATION_DEFAULT);
        elevation.setBorderRadius(borderRadius);

        this.setBackground(color);

        setIcon(icon);
        setText(text);
    }

    public void setIcon(ImageIcon icon) {
        if (icon instanceof DerivableIcon) {
            icon = (ImageIcon) ((DerivableIcon) icon).deriveIcon(getForeground());
        }
        this.icon = icon;
    }

    public void setText(String text) {
        this.text = text;
        updateSize();
    }

    public void setHeader(String text) {
        this.header = text;
        updateSize();
    }

    public void setElevationLevel(int level) {
        elevation.setLevel(level);
    }

    public void setBorderRadius(int border) {
        this.borderRadius = border;
        elevation.setBorderRadius(borderRadius);
    }

    @Override
    public void setBackground(Color color) {
        super.setBackground(color);
        this.setForeground(Utils.getForegroundAccording(color));
    }

    private void updateSize() {
        int width = 0;
        int heigth = 0;

        //calculate header
        StringTokenizer stHeader = new StringTokenizer(this.header, "\n");
        while (stHeader.hasMoreTokens()) {
            String tok = stHeader.nextToken();
            FontMetrics fm = Utils.fontMetrics(headerFont);
            int tokW = fm.stringWidth(tok);

            width = Math.max(width, tokW);
            heigth += fm.getAscent();
        }

        //calculate text
        StringTokenizer stText = new StringTokenizer(this.text, "\n");
        while (stText.hasMoreTokens()) {
            String tok = stText.nextToken();
            FontMetrics fm = Utils.fontMetrics(textFont);
            int tokW = fm.stringWidth(tok);

            width = Math.max(width, tokW);
            heigth += fm.getAscent() + 2;
        }
        textDim = new Dimension(width, heigth);
        this.setSize(width + this.icon.getIconWidth() + 70, Math.max(heigth, this.icon.getIconHeight()) + 40);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

//---------------------BACKGROUND-----------------------------------
        //Paint MaterialPanel background
        elevation.paint(g2);
        g2.translate(MaterialShadow.OFFSET_LEFT, MaterialShadow.OFFSET_TOP);

        final int offset_lr = MaterialShadow.OFFSET_LEFT + MaterialShadow.OFFSET_RIGHT;
        final int offset_td = MaterialShadow.OFFSET_TOP + MaterialShadow.OFFSET_BOTTOM;
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, borderRadius * 2, borderRadius * 2));
        g2.setClip(null);

        g2.translate(-MaterialShadow.OFFSET_LEFT, -MaterialShadow.OFFSET_TOP);

//------------------------ICON--------------------------------
        int xIcon = (getWidth() - textDim.width - icon.getIconWidth()) / 2 - 10;
        int yIcon = getHeight() / 2;
        if (this.icon != null) {
            yIcon = (getHeight() - icon.getIconHeight()) / 2;
            this.icon.paintIcon(this, g2, xIcon, yIcon);
        }
//--------------------------------------------------------
        //paint text
        g2.setColor(getForeground());

        int xText = xIcon + this.icon.getIconWidth() + 15;
        int yText = getHeight() / 2 - textDim.height / 2 - 8;

        g2.setFont(headerFont);
        StringTokenizer stHeader = new StringTokenizer(this.header, "\n");
        while (stHeader.hasMoreTokens()) {
            yText += g2.getFontMetrics().getAscent() + 2;
            String tok = stHeader.nextToken();
            g2.drawString(tok, xText, yText);
        }
        yText += 5;
        g2.setFont(textFont);
        StringTokenizer stText = new StringTokenizer(this.text, "\n");
        while (stText.hasMoreTokens()) {
            yText += g2.getFontMetrics().getAscent() + 2;
            String tok = stText.nextToken();
            g2.drawString(tok, xText, yText);
        }
    }

    public Font getHeaderFont() {
        return headerFont;
    }

    public void setHeaderFont(Font headerFont) {
        this.headerFont = headerFont;
    }

    public Font getTextFont() {
        return textFont;
    }

    public void setTextFont(Font textFont) {
        this.textFont = textFont;
    }

    public Dimension getTextDim() {
        return textDim;
    }

    public void setTextDim(Dimension textDim) {
        this.textDim = textDim;
    }

    public Cursor getCursor() {
        return cursor;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

}
