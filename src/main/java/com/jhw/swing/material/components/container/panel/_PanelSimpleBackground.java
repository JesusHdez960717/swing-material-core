package com.jhw.swing.material.components.container.panel;

import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _PanelSimpleBackground extends _PanelGradient {

    public _PanelSimpleBackground() {
        setBackground(PersonalizationHandler.getColor(Personalization.KEY_COLOR_BACKGROUND_PANEL));
    }

}
