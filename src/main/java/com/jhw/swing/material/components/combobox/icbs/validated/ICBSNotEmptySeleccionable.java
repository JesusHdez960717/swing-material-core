package com.jhw.swing.material.components.combobox.icbs.validated;

import com.jhw.swing.material.components.combobox.icbs.InputComboBoxSelection;
import com.jhw.swing.util.validations.icbs.ItemsListNotEmptyValidation;
import com.jhw.swing.util.validations.icbs.SeleccionableValidation;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class ICBSNotEmptySeleccionable<T> extends InputComboBoxSelection<T> {

    public ICBSNotEmptySeleccionable(String label) {
        this(label, "Seleccione...");
    }

    public ICBSNotEmptySeleccionable(String label, String hint) {
        super(label, hint);
        addValidations();
    }

    @Override
    public void setLabel(String label) {
        super.setLabel(label);
        addValidations();
    }

    private void addValidations() {
        String initial = "El campo de " + getLabel().toLowerCase();
        this.addPreValidation(new ItemsListNotEmptyValidation(ItemsListNotEmptyValidation.WRONG_TEXT, initial + " no contiene elementos.\nCree uno nuevo para seleccionarlo."));
        this.addPostValidation(new SeleccionableValidation(SeleccionableValidation.WRONG_TEXT, initial + " NO tiene\nningún elemento seleccionado, seleccione alguno."));
    }
}
