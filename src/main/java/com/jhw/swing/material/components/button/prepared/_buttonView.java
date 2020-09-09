package com.jhw.swing.material.components.button.prepared;

import com.jhw.swing.material.components.button._MaterialButton;
import java.awt.Dimension;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;

/**
 * MaterialButton con background getColorButtonView, e icon iconButtonView de la
 * personalizacion.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _buttonView extends _MaterialButton {

    public static _buttonView from() {
        return new _buttonView();
    }

    protected _buttonView() {
        this.setBackground(PersonalizationHandler.getColor(Personalization.KEY_COLOR_BUTTON_VIEW));
        this.setIcon(PersonalizationHandler.getDerivableIcon(Personalization.KEY_ICON_BUTTON_VIEW));
        this.setPreferredSize(new Dimension(125, 50));
    }

}
