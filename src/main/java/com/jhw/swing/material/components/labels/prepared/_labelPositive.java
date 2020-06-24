package com.jhw.swing.material.components.labels.prepared;

import com.jhw.swing.material.components.labels._MaterialLabel;
import com.jhw.swing.personalization.PersonalizationMaterial;

/**
 * Label con foreground getColorMoneyPositive de la personalización.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _labelPositive extends _MaterialLabel {

    public _labelPositive() {
        super();
        this.setForeground(PersonalizationMaterial.getInstance().getColorMoneyPositive());
    }

}
