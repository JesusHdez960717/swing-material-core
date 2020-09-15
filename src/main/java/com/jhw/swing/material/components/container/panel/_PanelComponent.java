package com.jhw.swing.material.components.container.panel;

import java.awt.BorderLayout;
import java.awt.Component;

/**
 *
 * @author Jessica Aidyl Garcia Albalah (jgarciaalbalah@gmail.com)
 */
public class _PanelComponent extends _PanelTransparent {

    public static _PanelComponent from() {
        return new _PanelComponent();
    }

    public void setComponent(Component c) {
        this.add(c);
        this.validate();
    }

    @Override
    public Component add(Component comp) {
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(comp, BorderLayout.CENTER);
        return comp;
    }
}
