package com.jhw.swing.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import com.jhw.swing.personalization.PersonalizationMaterial;
//import sun.font.FontDesignMetrics;
import com.jhw.swing.material.standars.MaterialColors;
import java.awt.Canvas;

/**
 * This class provides utilitary methods for Swing Material. These are public
 * and thus can be used directly.
 *
 * @author DragShot
 */
public class Utils {

    /**
     * A boolean flag for {@code getScreenSize()}, signaling if
     * {@code sun.java2d.SunGraphicsEnvironment.getUsableBounds()} is available
     * or not.<br/><br/>
     * Values:<br/><ul>
     * <li>{@code true}: Class/method is available.</li>
     * <li>{@code false}: Class/method is not available.</li></ul>
     */
    private static final boolean useSun2D;

    /**
     * If not {@code null}, this contains a reference to
     * {@code sun.java2d.SunGraphicsEnvironment.getUsableBounds()} via
     * Reflection.
     */
    private static final Method getUsableBounds;

    static {
        //Check if sun.java2d.SunGraphicsEnvironment.getUsableBounds()
        //is available.
        boolean found = false;
        Method getMethod = null;
        try {
            Class sunGE = Class.forName("sun.java2d.SunGraphicsEnvironment");
            Method[] meths = sunGE.getDeclaredMethods();
            for (Method meth : meths) {
                if (meth.getName().equals("getUsableBounds")
                        && Arrays.equals(meth.getParameterTypes(),
                                new Class[]{java.awt.GraphicsDevice.class})
                        && meth.getExceptionTypes().length == 0
                        && meth.getReturnType()
                        .equals(java.awt.Rectangle.class)) {
                    //We found it!
                    getMethod = meth;
                    found = true;
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            //It seems not
            found = false;
        }
        useSun2D = found;
        getUsableBounds = getMethod;
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        boolean progressiveBilinear = true;
        int type = (img.getTransparency() == Transparency.OPAQUE)
                ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage ret = (BufferedImage) img;
        BufferedImage scratchImage = null;
        Graphics2D g2 = null;
        int w, h;
        int prevW = ret.getWidth();
        int prevH = ret.getHeight();
        if (progressiveBilinear) {

            // Use multistep technique: start with original size,
            // then scale down in multiple passes with drawImage()
            // until the target size is reached
            w = img.getWidth();
            h = img.getHeight();
        } else {
            // Use one-step technique: scale directly from original
            // size to target size with a single drawImage() call
            w = newW;
            h = newH;
        }
        do {
            if (progressiveBilinear && w > newW) {
                w /= 2;
                if (w < newW) {
                    w = newW;
                }
            } else if (progressiveBilinear && w < newW) {
                w *= 2;
                if (w > newW) {
                    w = newW;
                }
            }
            if (progressiveBilinear && h > newH) {
                h /= 2;
                if (h < newH) {
                    h = newH;
                }
            } else if (progressiveBilinear && h < newH) {
                h *= 2;
                if (h > newH) {
                    h = newH;
                }
            }
            //se tuvo que comentar para que funcionara para aumentar
            //if (scratchImage == null) {
            // Use a single scratch buffer for all iterations
            // and then copy to the final, correctly sized image
            // before returning
            scratchImage = new BufferedImage(w, h, type);
            g2 = scratchImage.createGraphics();
            //}

            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2.drawImage(ret, 0, 0, w, h, 0, 0, prevW, prevH, null);
            prevW = w;
            prevH = h;
            ret = scratchImage;
        } while (w != newW || h != newH);
        if (g2 != null) {
            g2.dispose();
        }
// If we used a scratch buffer that is larger than our
// target size, create an image of the right size and copy
// the results into it
        if (newW != ret.getWidth() || newH != ret.getHeight()) {
            scratchImage = new BufferedImage(newW,
                    newH, type);
            g2 = scratchImage.createGraphics();
            g2.drawImage(ret, 0, 0, null);
            g2.dispose();
            ret = scratchImage;
        }
        return ret;
    }

    /**
     * Ejecuta un sonido del sistema. <\br>
     * Solo se ejecuta si en las opciones de personalizacion se encuentra true
     * el doBeep.
     */
    public static void beep() {
        if (PersonalizationMaterial.getInstance().isDoBeep()) {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    /**
     * Devuelve el objeto FontMetrics asociado a una fuente determinada.
     *
     * @param font Font de la que se quiere extraer su FontMetrics
     * @return FontMetrics of the font
     */
    public static FontMetrics fontMetrics(Font font) {
        return new Canvas().getFontMetrics(font);
        //return FontDesignMetrics.getMetrics(font);
        //return new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR).getGraphics().getFontMetrics();
    }

    /**
     * Checks the area available in the desktop, excluding the taskbar. In order
     * to do this, an attempt to call
     * <code>sun.java2d.SunGraphicsEnvironment.getUsableBounds()</code> is
     * performed. If this can't be done, the method falls back to the default
     * <code>Toolkit.getDefaultToolkit().getScreenSize()</code>, although such
     * method doesn't exclude the taskbar area.
     *
     * @return A Rectangle with the usable area for maximized windows.
     * @author DragShot
     */
    public static Rectangle getScreenSize() {
        Rectangle screen;
        if (useSun2D) { //Use sun.java2d.SunGraphicsEnvironment.getUsableBounds()
            try {
                Frame frame = new Frame();
                GraphicsConfiguration config = frame.getGraphicsConfiguration();
                screen = (Rectangle) getUsableBounds.invoke(null, config.getDevice());
                frame.dispose();
            } catch (Exception ex) {
                //If something doesn't work, fallback to Toolkit
                Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
                screen = new Rectangle(0, 0, size.width, size.height);
            }
        } else { //Do it the traditional way
            Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
            screen = new Rectangle(0, 0, size.width, size.height);
        }
        return screen;
    }

    /**
     * Checks if the translucency effect is supported. Java 6 does not support
     * this. Only Java 7 and higher VMs might do, depending of the Graphics
     * Environment and OS.
     *
     * @return <code>true</code> if translucency is supported,
     * <code>false</code> otherwise.
     * @author DragShot
     */
    public static boolean isTranslucencySupported() {
        boolean nativeTrans;
        if (System.getProperty("java.version").contains("1.6")) {
            //Don't even bother: window translucency doesn't exist before JDK 1.7
            nativeTrans = false;
        } else {
            nativeTrans = GraphicsEnvironment
                    .getLocalGraphicsEnvironment().getDefaultScreenDevice()
                    .isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSLUCENT);
        }
        return nativeTrans;
    }

    /**
     * Determines if a given {@link Color} is dark enough for white text to be
     * seen more easily than black text. This tries to stick to the Material
     * Color Guide as much as possible, and although two or three of the color
     * pairs doesn't match, the results are still good enough.
     *
     * @param color a {@link Color} to evaluate
     * @return {@code true} if the provided color is dark, {@code false}
     * otherwise.
     * @author DragShot
     */
    public static boolean isDark(Color color) {
        //return (color.getRed()*0.299 + color.getGreen()*0.587 + color.getBlue()*0.114) < (0.6*255);
        //return (color.getRed() + color.getGreen() + color.getBlue())/3 < (0.63*255);
        return (color.getRed() * 0.2125 + color.getGreen() * 0.7154 + color.getBlue() * 0.0721) < (0.535 * 255);
        //return (color.getRed()*0.21 + color.getGreen()*0.72 + color.getBlue()*0.07) < (0.54*255);
    }

    public static Color getForegroundAccording(Color color) {
        return isDark(color) ? PersonalizationMaterial.getInstance().getColorForegroundForDark() : PersonalizationMaterial.getInstance().getColorForegroundForWhite();
    }

    /**
     * Utilitary method for getting a darker version of a provided Color. Unlike
     * {@link Color#darker()}, this decreases color at a fixed step instead of a
     * proportional.
     *
     * @param color the original color
     * @return a {@link Color} sightly darker than the one input.
     */
    public static Color darken(Color color) {
        int r = wrapU8B(color.getRed() - 30);
        int g = wrapU8B(color.getGreen() - 30);
        int b = wrapU8B(color.getBlue() - 30);
        return new Color(r, g, b, color.getAlpha());
    }

    /**
     * Utilitary method for getting a darker version of a provided Color. Unlike
     * {@link Color#brighter()}, this increases color at a fixed step instead of
     * a proportional.
     *
     * @param color the original color
     * @return a {@link Color} sightly brighter than the one input.
     */
    public static Color brighten(Color color) {
        int r = wrapU8B(color.getRed() + 30);
        int g = wrapU8B(color.getGreen() + 30);
        int b = wrapU8B(color.getBlue() + 30);
        return new Color(r, g, b, color.getAlpha());
    }

    private static int wrapU8B(int i) {
        return Math.min(255, Math.max(0, i));
    }

    /**
     * Utilitary method for getting a copy of a provided Color but using an
     * specific opacity mask. Intented for use within the library.
     *
     * @param color the color to use as base
     * @param bitMask the bitmask to apply, where the bits 25 to 32 are used
     * @return a copy of the given color, with a modified alpha value
     */
    public static Color applyAlphaMask(Color color, int bitMask) {
        return new Color(color.getRGB() & 0x00FFFFFF | (bitMask & 0xFF000000), true);
    }

    //Uncomment this block in order to test #isDark() against all the color constants in Material Color
    public static void main(String[] args) {
        Field[] fields = MaterialColors.class.getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())
                    && Color.class.isAssignableFrom(field.getType())) {
                try {
                    System.out.println(field.getType().getName() + " " + field.getName() + (isDark((Color) field.get(null)) ? " is dark" : " is light"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
