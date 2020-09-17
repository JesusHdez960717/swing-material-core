package com.jhw.swing.prepared.button;

import com.jhw.swing.material.components.button._MaterialButton;
import java.awt.Dimension;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.injection.Background_Force_Foreground;
import com.jhw.swing.material.injection.Foreground_Force_Icon;
import com.jhw.swing.material.injection.MaterialSwingInjector;

/**
 * MaterialButton con background getColorButtonView, e icon iconButtonView de la
 * personalizacion.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _buttonView extends _MaterialButton {

    public static _buttonView from() {
        return MaterialSwingInjector.getImplementation(_buttonView.class);
    }

    /**
     * Usar _buttonView.from() para proxy y AOP
     *
     * @deprecated
     */
    @Deprecated
    public _buttonView() {
        this.setIcon(PersonalizationHandler.getDerivableIcon(Personalization.KEY_ICON_BUTTON_VIEW));
        this.setBackground(PersonalizationHandler.getColor(Personalization.KEY_COLOR_BUTTON_VIEW));
        this.setPreferredSize(new Dimension(125, 50));
    }

}
