package com.jhw.swing.personalization;

import org.jdesktop.swing.animation.timing.sources.SwingTimerTimingSource;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class Inistanciables {

    private static SwingTimerTimingSource timer;

    public static SwingTimerTimingSource getSwingTimerTimingSource() {
        if (timer == null) {
            timer = new SwingTimerTimingSource();
            timer.init();
        }
        return timer;
    }

}
