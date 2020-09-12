package com.jhw.swing.material.components.labels;

import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.injection.Background_Force_Foreground;
import com.jhw.swing.material.injection.Foreground_Force_Icon;

/**
 * Label con foreground getColorMoneyNegative de la personalizacion.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _MaterialLabelNegative extends _MaterialLabelMoney {

    public static _MaterialLabelNegative from() {
        return new _MaterialLabelNegative();
    }

    public _MaterialLabelNegative() {
        this.setForeground(PersonalizationHandler.getColor(Personalization.KEY_COLOR_MONEY_NEGATIVE));
    }

}
