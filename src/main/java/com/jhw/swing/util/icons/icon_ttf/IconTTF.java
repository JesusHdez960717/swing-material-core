package com.jhw.swing.util.icons.icon_ttf;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

import com.jhw.swing.util.icons.DerivableIcon;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialIcons;

/**
 * Icon extracted from a true type font (ttf)
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class IconTTF extends DerivableIcon {

    private char ch;

    private Color color = MaterialColors.BLACK;

    private float size = 24f;

    public IconTTF(ImageIcon icon) {
        super(icon.getImage());
    }

    public IconTTF(Image icon) {
        super(icon);
    }

    public IconTTF(BufferedImage icon) {
        super(icon);
    }

    private IconTTF(ImageIcon icon, char c, Color color, float size) {
        super(icon.getImage());
        this.ch = c;
        this.color = color;
        this.size = size;
    }

    public IconTTF(char c) {
        this.ch = c;

        loadInitialImage();
    }

    public IconTTF(char c, Color color, float size) {
        this.ch = c;
        this.color = color;
        this.size = size;

        loadInitialImage();
    }

    public char getCh() {
        return ch;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public float getSize() {
        return size;
    }

    private void loadInitialImage() {
        ImageIcon extractedIcon = extractIcon(MaterialIcons.ICON_FONT, ch, color, size);
        super.setImage(extractedIcon.getImage());
    }

    @Override
    public IconTTF deriveIcon(Color color) {
        return buildIcon(ch, color, size);
    }

    @Override
    public IconTTF deriveIcon(float size) {
        return buildIcon(ch, color, size);
    }

    private IconTTF buildIcon(char ch, Color color, float size) {
        ImageIcon extractedIcon = extractIcon(MaterialIcons.ICON_FONT, ch, color, size);
        return new IconTTF(extractedIcon, ch, color, size);
    }

    /**
     * Agregados los hints de Graphics a mano xq se llaman antes que se llame la
     * personalizacion.
     *
     * @param font TTF de donde se van a sacar los iconos.
     * @param ch char que se representa el icono.
     * @param color color del que se va a mostrar el icono.
     * @param size tamanno del icono.
     * @return ImageIcon extraido con las propiedades especificas.
     */
    public static ImageIcon extractIcon(Font font, char ch, Color color, float size) {
        String str = "" + ch;

        //First, we have to calculate the string's width and height
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);

        Graphics2D g2 = (Graphics2D) img.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        //Set the font to be used when drawing the string
        //set up the size and force to use the plain style
        font = font.deriveFont(size).deriveFont(Font.PLAIN);
        g2.setFont(font);

        //Get the string visual bounds
        FontRenderContext frc = g2.getFontMetrics().getFontRenderContext();
        Rectangle2D rect = font.getStringBounds(str, frc);
        //Release resources
        g2.dispose();

        //Then, we have to draw the string on the final image
        //Create a new image where to print the character
        img = new BufferedImage((int) Math.ceil(rect.getWidth()), (int) Math.ceil(rect.getHeight()), BufferedImage.TYPE_4BYTE_ABGR);

        g2 = (Graphics2D) img.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        g2.setColor(color); //Otherwise the text would be white
        g2.setFont(font);

        //Calculate x and y for that string
        FontMetrics fm = g2.getFontMetrics();
        int x = 0;
        int y = fm.getAscent(); //getAscent() = baseline
        g2.drawString(str, x, y);

        //Release resources
        g2.dispose();

        //Return the image
        return new ImageIcon(img);
    }
}
