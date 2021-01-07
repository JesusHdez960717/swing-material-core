package com.root101.swing.ui.animation;

import javax.swing.JComponent;
import java.awt.Color;

public class MaterialUIMovement {

    public static final int STEPS = 5;
    public static final int INTERVAL = 1000 / 30;//30 FPS

    private MaterialUIMovement() {
    }

    public static MaterialUITimer getMovement(JComponent c, Color fadeTo, int steps, int interval) {
        return new MaterialUITimer(c, fadeTo, steps, interval);
    }

    /**
     * You can also pass in extra parameters indicating how many intermediate
     * colors to display, as well as the "frame rate" of the animation there
     * will be 5 intermediate colors displayed in the transition from the
     * original components color to the new one specified the "frame rate" of
     * the transition will be 1000 / 30, or 30 FPS the animation will take 5 *
     * 1000 / 30 = 166.666... milliseconds to complete
     *
     * @param c
     * @param fadeTo
     * @return
     */
    public static MaterialUITimer getMovement(JComponent c, Color fadeTo) {
        return getMovement(c, fadeTo, STEPS, INTERVAL);
    }

    /**
     * This method create a new effect mouse hover static, not create a wake
     * effect This method is util in all component for click, an example: The
     * button for JSpinner, JCombobox, JScroolbar
     *
     * @param c is the component
     * @param colorEffect is the color for effect, (For using color, look the
     * MaterialColors class)
     * @param colorOnClick is the color of the component on click on it
     * @return a new MaterialUIStaticMovement this class implement a only
     * MouseListner for moment
     * @author https://github.com/vincenzopalazzo
     */
    public static MaterialUIStaticMovement getStaticMovement(JComponent c, Color colorEffect, Color colorOnClick) {
        if (c == null || colorEffect == null) {
            throw new IllegalArgumentException("Che input arguments is/are null");
        }
        return new MaterialUIStaticMovement(c.getBackground(), colorEffect, colorOnClick);
    }
}
