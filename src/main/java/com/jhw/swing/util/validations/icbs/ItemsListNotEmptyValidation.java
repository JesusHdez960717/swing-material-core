package com.jhw.swing.util.validations.icbs;

import com.jhw.swing.material.components.combobox.icbs.InputComboBoxSelection;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ItemsListNotEmptyValidation extends ICBSValidation<InputComboBoxSelection> {

    public static final String WRONG_TEXT = "Nada para seleccionar. Cree uno.";

    public ItemsListNotEmptyValidation() {
        super(WRONG_TEXT, WRONG_TEXT);
    }

    public ItemsListNotEmptyValidation(String wrongText) {
        super(wrongText, wrongText);
    }

    public ItemsListNotEmptyValidation(String wrongText, String detailedText) {
        super(wrongText, detailedText);
    }

    @Override
    public boolean validate(InputComboBoxSelection obj) {
        return obj.getComboBox().getItemCount() > 0;
    }

}
