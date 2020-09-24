/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.container.panel;

import com.jhw.swing.material.injection.Background_Force_Foreground;
import com.jhw.swing.material.injection.Foreground_Force_Icon;
import com.jhw.swing.material.injection.MaterialSwingInjector;
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

    public static MaterialPanelBorder from() {
        return MaterialSwingInjector.getImplementation(_MaterialPanelComponent.class);
    }

    private final static int DEFAULT_GAP = 10;

    /**
     * Use _MaterialPanelComponent.from() para proy y AOP
     *
     * @param gap
     * @deprecated
     */
    @Deprecated
    public _MaterialPanelComponent() {
        this(DEFAULT_GAP);
    }

    /**
     * Use _MaterialPanelComponent.from() para proy y AOP
     *
     * @param gap
     * @deprecated
     */
    @Deprecated
    public _MaterialPanelComponent(int gap) {
        this.setLayout(new BorderLayout());
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
        this.add(comp, BorderLayout.CENTER);
        return comp;
    }

}
