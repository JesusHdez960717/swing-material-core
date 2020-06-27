package com.jhw.swing.material.standars;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * The MaterialFontRoboto font.
 *
 * @see <a
 * href="https://www.google.com/design/spec/resources/roboto-noto-fonts.html">MaterialFontRoboto
 * &amp; Noto fonts (Google design guidelines)</a>
 */
public class MaterialFontRoboto {

    private static final Map<TextAttribute, Object> fontSettings = new HashMap<TextAttribute, Object>();
    public static final Font BLACK = loadFont("/fonts/Roboto-Black.ttf").deriveFont(Font.BOLD);
    public static final Font BLACK_ITALIC = loadFont("/fonts/Roboto-BlackItalic.ttf").deriveFont(Font.BOLD | Font.ITALIC);
    public static final Font BOLD = loadFont("/fonts/Roboto-Bold.ttf").deriveFont(Font.BOLD);
    public static final Font BOLD_ITALIC = loadFont("/fonts/Roboto-BoldItalic.ttf").deriveFont(Font.BOLD | Font.ITALIC);
    public static final Font ITALIC = loadFont("/fonts/Roboto-Italic.ttf").deriveFont(Font.ITALIC);
    public static final Font LIGHT = loadFont("/fonts/Roboto-Light.ttf").deriveFont(Font.PLAIN);
    public static final Font LIGHT_ITALIC = loadFont("/fonts/Roboto-LightItalic.ttf").deriveFont(Font.ITALIC);
    public static final Font MEDIUM = loadFont("/fonts/Roboto-Medium.ttf").deriveFont(Font.PLAIN);
    public static final Font MEDIUM_ITALIC = loadFont("/fonts/Roboto-MediumItalic.ttf").deriveFont(Font.ITALIC);
    public static final Font REGULAR = loadFont("/fonts/Roboto-Regular.ttf").deriveFont(Font.PLAIN);
    public static final Font THIN = loadFont("/fonts/Roboto-Thin.ttf").deriveFont(Font.PLAIN);
    public static final Font THIN_ITALIC = loadFont("/fonts/Roboto-ThinItalic.ttf").deriveFont(Font.ITALIC);

    private static Font loadFont(String fontPath) {
        if (fontSettings.isEmpty()) {
            fontSettings.put(TextAttribute.SIZE, new Float(11 * Toolkit.getDefaultToolkit().getScreenResolution() / 72.0));
            fontSettings.put(TextAttribute.KERNING, TextAttribute.KERNING_ON);
        }

        try (InputStream inputStream = MaterialFontRoboto.class.getResourceAsStream(fontPath)) {
            return Font.createFont(Font.TRUETYPE_FONT, inputStream).deriveFont(fontSettings);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            throw new RuntimeException("Font " + fontPath + " wasn't loaded");
        }
    }
}
