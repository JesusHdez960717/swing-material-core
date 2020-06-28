package com.jhw.swing.material.components.container.panel;

import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.personalization.PersonalizationMaterial;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _PanelSimpleBackground extends _PanelGradient {

    public _PanelSimpleBackground() {
        setBackground(PersonalizationMaterial.getInstance().getColorBackgroundPanel());
    }

}
