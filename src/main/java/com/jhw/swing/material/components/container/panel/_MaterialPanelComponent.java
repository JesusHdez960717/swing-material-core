/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.container.panel;

import com.jhw.swing.material.injection.Background_Force_Foreground;
import com.jhw.swing.material.injection.Foreground_Force_Icon;
import com.jhw.swing.material.standards.MaterialShadow;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _MaterialPanelComponent extends _MaterialPanel {

    public static _MaterialPanelComponent from() {
        return new _MaterialPanelComponent();
    }

    private final static int DEFAULT_GAP = 10;

    protected _MaterialPanelComponent() {
        this(DEFAULT_GAP);
    }

    protected _MaterialPanelComponent(int gap) {
        setGap(gap);
    }

    protected void setGap(int gap) {
        this.setBorder(new EmptyBorder(
                MaterialShadow.OFFSET_TOP + gap,
                MaterialShadow.OFFSET_LEFT + gap,
                MaterialShadow.OFFSET_BOTTOM + gap,
                MaterialShadow.OFFSET_RIGHT + gap));
    }

    @Override
    public Component add(Component comp) {
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(comp, BorderLayout.CENTER);
        return comp;
    }

}
