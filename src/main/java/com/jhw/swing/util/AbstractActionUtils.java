package com.jhw.swing.util;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class AbstractActionUtils {

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
}
