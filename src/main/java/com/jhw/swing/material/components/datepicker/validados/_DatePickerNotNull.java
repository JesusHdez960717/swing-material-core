package com.jhw.swing.material.components.datepicker.validados;

import com.jhw.swing.material.components.datepicker._MaterialDatePicker;
import com.jhw.swing.util.validations.datepicker.DateNotNullValidation;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class _DatePickerNotNull extends _MaterialDatePicker {

    public _DatePickerNotNull() {
        this("Fecha");
    }

    public _DatePickerNotNull(String label) {
        super(label);
        addValidations();
    }

    @Override
    public void setLabel(String label) {
        super.setLabel(label);
        addValidations();
    }

    private void addValidations() {
        String initial = "El campo de " + getLabel().toLowerCase();
        this.addPostValidation(new DateNotNullValidation(DateNotNullValidation.WRONG_TEXT, initial + " NO tiene\nnada seleccionado, seleccione alguna.") {
        });
    }
}
