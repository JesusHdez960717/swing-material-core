package com.jhw.swing.material.components.container.layout;

import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.standars.MaterialColors;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GridLayoutContainer extends _PanelGradient {

    public GridLayoutContainer(int rows, int cols, int hgap, int vgap) {
        this.setOpaque(false);
        this.setBackground(MaterialColors.TRANSPARENT);
        this.setLayout(new java.awt.GridLayout(rows, cols, hgap, vgap));
    }

}
