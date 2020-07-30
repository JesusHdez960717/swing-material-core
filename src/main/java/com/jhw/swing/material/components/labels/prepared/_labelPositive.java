package com.jhw.swing.material.components.labels.prepared;

import com.jhw.swing.material.components.labels._MaterialLabel;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;

/**
 * Label con foreground getColorMoneyPositive de la personalizacion.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _labelPositive extends _MaterialLabel {

    public _labelPositive() {
        super();
        this.setForeground(PersonalizationHandler.getColor(Personalization.KEY_COLOR_MONEY_POSITIVE));
    }

}
