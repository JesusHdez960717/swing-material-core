package com.jhw.swing.ui.utils;

import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelListener;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialManagerListener {

    /**
     * Look this if you would change this function
     * https://bugs.java.com/bugdatabase/view_bug.do?bug_id=4380536
     */
    public static void removeAllMouseListener(JButton button) {
        if (button == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        for (MouseListener mouseListener : button.getListeners(MouseListener.class)) {
            button.removeMouseListener(mouseListener);
        }
    }

    public static void removeAllScrollpaneListener(JScrollPane scroll) {
        if (scroll == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        for (MouseWheelListener mouseWheelListener : scroll.getMouseWheelListeners()) {
            scroll.removeMouseWheelListener(mouseWheelListener);
        }
    }
}
