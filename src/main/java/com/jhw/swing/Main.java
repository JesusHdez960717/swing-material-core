package com.jhw.swing;

import com.jhw.swing.material.standars.MaterialFontRoboto;
import com.jhw.swing.util.Utils;
import java.awt.Canvas;
import java.awt.FontMetrics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class Main {

    public static void main(String args[]) throws Exception {
        FontMetrics fm = Utils.fontMetrics(MaterialFontRoboto.MEDIUM);
        System.out.println("ascent " + fm.getAscent());
        System.out.println("width  " + fm.stringWidth("1"));
        
        
        FontMetrics fm2 = new Canvas().getFontMetrics(MaterialFontRoboto.MEDIUM);
        System.out.println("ascent " + fm2.getAscent());
        System.out.println("width  " + fm2.stringWidth("123"));
        
        
        FontMetrics fm3 = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR).getGraphics().getFontMetrics();
        System.out.println("ascent " + fm3.getAscent());
        System.out.println("width  " + fm3.stringWidth("123"));
    }
}
