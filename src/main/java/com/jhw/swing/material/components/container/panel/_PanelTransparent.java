package com.jhw.swing.material.components.container.panel;

import java.awt.Graphics;
import javax.swing.JPanel;
import com.jhw.swing.util.interfaces.MaterialComponent;

/**
 * Panel transparente. Se usa como container de otras cosas cuando no se quiere
 * ver el fondo.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com) el 28/01/2020
 */
public class _PanelTransparent extends JPanel implements MaterialComponent {

    public static _PanelTransparent from() {
        return new _PanelTransparent();
    }

    public _PanelTransparent() {
        this.setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
    }

}
