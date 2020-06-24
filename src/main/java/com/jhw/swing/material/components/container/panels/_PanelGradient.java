package com.jhw.swing.material.components.container.panels;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.enums.GradientEnum;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.material.standars.MaterialColors;

/**
 * Componente extraido su logica de edisoncorSX.
 */
public class _PanelGradient extends JPanel implements MaterialComponent {

    protected Color primaryColor = MaterialColors.BLUE_600;
    protected Color secundaryColor = MaterialColors.BLACK;
    protected GradientEnum gradient = GradientEnum.HORIZONTAL;
    private Icon icon;
    private Image image = null;
    private int borderRadius = 0;

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

    /**
     * Sets the background color of this panel. Keep on mind that setting a
     * background color in a Material component like this will also set the
     * foreground color to either white or black, depending of how bright or
     * dark is the chosen background color.
     * <p/>
     * <b>NOTE:</b> It is up to the look and feel to honor this property, some
     * may choose to ignore it. To avoid any conflicts, using the
     * <a
     * href="https://docs.oracle.com/javase/7/docs/api/javax/swing/plaf/metal/package-summary.html">
     * Metal Look and Feel</a> is recommended.
     *
     * @param bg the desired background <code>Color</code>
     */
    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        this.setPrimaryColor(bg);
        this.setSecundaryColor(bg);
        this.setForeground(Utils.getForegroundAccording(bg));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        if (this.image != null) {
            g2.drawImage(this.image, 0, 0, getWidth(), getHeight(), null);
        } else {
            g2.setPaint(getGradientePaint());
            g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), borderRadius * 2, borderRadius * 2));
            g2.setColor(getForeground());
        }
        //super.paintChildren(g);
    }

    public Paint getGradientePaint() {
        int x2 = getWidth();
        int y2 = getHeight();
        switch (this.gradient) {
            case HORIZONTAL:
                return new GradientPaint((float) (getWidth() / 2), (float) 0, this.primaryColor, (float) (getWidth() / 2), (float) getHeight(), this.secundaryColor);
            case VERTICAL:
                return new GradientPaint((float) 0, (float) (getHeight() / 2), this.primaryColor, (float) getWidth(), (float) (getHeight() / 2), this.secundaryColor);
            case VERTICAL_3_4:
                return new GradientPaint((float) getWidth() / 4, (float) (getHeight() / 2), this.primaryColor, (float) getWidth(), (float) (getHeight() / 2), this.secundaryColor);
            case ESQUINA_1:
                return new RadialGradientPaint((float) 0, (float) 0, (float) getWidth(), new float[]{0.0f, 1.0f}, new Color[]{this.primaryColor, this.secundaryColor});
            case ESQUINA_2:
                return new RadialGradientPaint((float) getWidth(), (float) 0, (float) getWidth(), new float[]{0.0f, 1.0f}, new Color[]{this.primaryColor, this.secundaryColor});
            case ESQUINA_3:
                return new RadialGradientPaint((float) getWidth(), (float) getHeight(), (float) getWidth(), new float[]{0.0f, 1.0f}, new Color[]{this.primaryColor, this.secundaryColor});
            case ESQUINA_4:
                return new RadialGradientPaint((float) 0, (float) getHeight(), (float) getWidth(), new float[]{0.0f, 1.0f}, new Color[]{this.primaryColor, this.secundaryColor});
            case CIRCULAR:
                return new RadialGradientPaint((float) (getWidth() / 2), (float) (getHeight() / 2), (float) getWidth(), new float[]{0.0f, 0.5f}, new Color[]{this.primaryColor, this.secundaryColor});
            case CENTRAL:
                return new LinearGradientPaint((float) (getWidth() / 2), (float) 0, (float) (getWidth() / 2), (float) getHeight(), new float[]{0.0f, 0.5f, 1.0f}, new Color[]{this.primaryColor, this.secundaryColor, this.primaryColor});
            case AQUA:
                return new LinearGradientPaint(0.0f, 0.0f, 0.0f, (float) getHeight(), new float[]{0.0f, 0.3f, 0.5f, 1.0f}, new Color[]{this.primaryColor.brighter().brighter(), this.primaryColor.brighter(), this.secundaryColor.darker().darker(), this.secundaryColor.darker()});
            default:
                return new GradientPaint(0.0f, 0.0f, this.primaryColor, (float) x2, (float) y2, this.secundaryColor);
        }
    }

    public Color getPrimaryColor() {
        return this.primaryColor;
    }

    public void setPrimaryColor(Color primaryColor) {
        this.primaryColor = primaryColor;
    }

    public Color getSecundaryColor() {
        return this.secundaryColor;
    }

    public void setSecundaryColor(Color colorSecundario) {
        this.secundaryColor = colorSecundario;
    }

    public GradientEnum getGradient() {
        return this.gradient;
    }

    public void setGradient(GradientEnum gradient) {
        this.gradient = gradient;
    }

    public Icon getIcon() {
        return this.icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
        if (icon != null) {
            this.image = ((ImageIcon) icon).getImage();
        }
    }
}
