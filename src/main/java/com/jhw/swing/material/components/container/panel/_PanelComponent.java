package com.jhw.swing.material.components.container.panel;

import java.awt.Component;
import java.awt.GridLayout;

/**
 *
 * @author Jessica Aidyl Garcia Albalah (jgarciaalbalah@gmail.com)
 */
public class _PanelComponent extends _PanelTransparent {

    public void setComponent(Component c) {
        this.setLayout(new GridLayout(1, 1));
        this.add(c);
        this.validate();
    }
}
