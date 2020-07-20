/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.container.panel.prepared;

import com.jhw.swing.material.components.container.panel._MaterialPanel;
import com.jhw.swing.material.standars.MaterialShadow;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialPanelComponent extends _MaterialPanel {

    private final static int DEFAULT_GAP = 10;

    public _MaterialPanelComponent() {
        this(DEFAULT_GAP);
    }

    public _MaterialPanelComponent(int gap) {
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(
                MaterialShadow.OFFSET_TOP + gap,
                MaterialShadow.OFFSET_LEFT + gap,
                MaterialShadow.OFFSET_BOTTOM + gap,
                MaterialShadow.OFFSET_RIGHT + gap));
    }

    public void setComponent(Component comp) {
        this.removeAll();
        this.add(comp, BorderLayout.CENTER);
    }
}
