package com.jhw.swing.material.components.button.prepared;

import com.jhw.swing.material.components.button._MaterialButton;
import java.awt.Dimension;
import com.jhw.swing.personalization.PersonalizationMaterial;

/**
 * MaterialButton con background getColorButtonAdd, e icon iconButtonAdd de la
 * personalizacion.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _buttonAddEdit extends _MaterialButton {

    public _buttonAddEdit() {
        super();
        this.setBackground(PersonalizationMaterial.getInstance().getColorButtonAdd());
        this.setIcon(PersonalizationMaterial.getInstance().getIconButtonAdd());
        this.setPreferredSize(new Dimension(125, 50));
    }

    public void isCreated(boolean created) {
        this.setIcon(created ? PersonalizationMaterial.getInstance().getIconButtonAdd() : PersonalizationMaterial.getInstance().getIconButtonEdit());
        this.setText(created ? "Crear" : "Editar");
        this.setBackground(created ? PersonalizationMaterial.getInstance().getColorButtonAdd() : PersonalizationMaterial.getInstance().getColorButtonEdit());
    }
}
