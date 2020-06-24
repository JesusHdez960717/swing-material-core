package com.jhw.swing.util.validations.icbs;

import com.jhw.swing.material.components.combobox.icbs.InputComboBoxSelection;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SeleccionableValidation extends ICBSValidation<InputComboBoxSelection> {

    public static final String WRONG_TEXT = "Seleccione un elemento.";

    public SeleccionableValidation() {
        super(WRONG_TEXT, WRONG_TEXT);
    }

    public SeleccionableValidation(String wrongText) {
        super(wrongText, wrongText);
    }

    public SeleccionableValidation(String wrongText, String detailedText) {
        super(wrongText, detailedText);
    }

    @Override
    public boolean validate(InputComboBoxSelection obj) {
        return obj.getComboBox().getSelectedIndex() > 0;
    }

}
