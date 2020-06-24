package com.jhw.swing.material.components.button.prepared;

import com.jhw.swing.material.components.button._MaterialButton;
import java.awt.Dimension;
import com.jhw.swing.personalization.PersonalizationMaterial;

/**
 * MaterialButton con background getColorButtonView, e icon iconButtonView de la
 * personalización.
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class _buttonView extends _MaterialButton {

    public _buttonView() {
        super();
        this.setBackground(PersonalizationMaterial.getInstance().getColorButtonView());
        this.setIcon(PersonalizationMaterial.getInstance().getIconButtonView());
        this.setPreferredSize(new Dimension(125, 50));
    }

}
