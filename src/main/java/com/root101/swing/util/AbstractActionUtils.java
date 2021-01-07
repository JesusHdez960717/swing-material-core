package com.root101.swing.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class AbstractActionUtils {

    public static final String KEY_BACKGROUND = "BACKGROUND";
    public static final String KEY_FOREGROUND = "FOREGROUND";

    public static AbstractAction from(ImageIcon icon) {
        return new AbstractAction("empty", icon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                return;
            }
        };
    }

    public static AbstractAction from(String name, ImageIcon icon) {
        return new AbstractAction(name, icon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                return;
            }
        };
    }

    public static AbstractAction from(String name, ImageIcon icon, String tooltip, ActionListener l) {
        AbstractAction a = new AbstractAction(name, icon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.actionPerformed(e);
            }
        };
        a.putValue(Action.SHORT_DESCRIPTION, tooltip);
        return a;
    }
}
