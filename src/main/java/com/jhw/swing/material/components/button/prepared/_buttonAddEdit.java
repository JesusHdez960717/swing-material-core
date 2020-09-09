package com.jhw.swing.material.components.button.prepared;

import com.jhw.swing.material.components.button._MaterialButton;
import java.awt.Dimension;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.injection.Background_Force_Foreground;
import com.jhw.swing.material.injection.Foreground_Force_Icon;

/**
 * MaterialButton con background getColorButtonAdd, e icon iconButtonAdd de la
 * personalizacion.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _buttonAddEdit extends _MaterialButton {

    public static _buttonAddEdit from() {
        return new _buttonAddEdit();
    }

    protected _buttonAddEdit() {
        this.setBackground(PersonalizationHandler.getColor(Personalization.KEY_COLOR_BUTTON_ADD));
        this.setIcon(PersonalizationHandler.getDerivableIcon(Personalization.KEY_ICON_BUTTON_ADD));
        this.setPreferredSize(new Dimension(125, 50));
    }

    public void isCreated(boolean created) {
        this.setIcon(created ? PersonalizationHandler.getDerivableIcon(Personalization.KEY_ICON_BUTTON_ADD) : PersonalizationHandler.getDerivableIcon(Personalization.KEY_ICON_BUTTON_EDIT));
        this.setText(created ? "Crear" : "Editar");
        this.setBackground(created ? PersonalizationHandler.getColor(Personalization.KEY_COLOR_BUTTON_ADD) : PersonalizationHandler.getColor(Personalization.KEY_COLOR_BUTTON_EDIT));
    }
}
