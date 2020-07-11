package com.jhw.swing.util.icons;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 * Interfaz a implementar por los Iconos que permiten el derive a diferentes
 * colores y tamaños.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class DerivableIcon extends ImageIcon {

    public DerivableIcon() {
        super();
    }

    public DerivableIcon(ImageIcon icon) {
        super(icon.getImage());
    }

    public DerivableIcon(Image icon) {
        super(icon);
    }

    public DerivableIcon(BufferedImage icon) {
        super(icon);
    }

    /**
     * Derive the icon to the specified size, both width and height will take
     * the same value as size.
     *
     * @param size the w and h of the result icon.
     * @return The icon.
     */
    public abstract DerivableIcon deriveIcon(float size);

    /**
     * Derive the icon to the specified Color, it will fill the icon with the
     * color.
     *
     * @param color the fill color of the resulting icon.
     * @return The icon.
     */
    public abstract DerivableIcon deriveIcon(Color color);
    
    public abstract Color getColor();
    
    public abstract float getSize();
}
