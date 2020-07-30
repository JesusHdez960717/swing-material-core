package com.jhw.swing.util;

import java.awt.*;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;

public class MaterialDrawingUtils {

    static {
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        System.setProperty("sun.java2d.xrender", "true");
    }

    public static Graphics2D getAliasedGraphics(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (PersonalizationHandler.getBoolean(Personalization.KEY_USE_ANTIALIASING)) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        }
        return g2;
    }
}
