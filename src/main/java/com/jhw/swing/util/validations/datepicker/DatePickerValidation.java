package com.jhw.swing.util.validations.datepicker;

import com.jhw.swing.util.validations.Validation;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public abstract class DatePickerValidation<T> extends Validation<T> {

    public static final String WRONG_TEXT = "Error en este campo de fecha";

    public DatePickerValidation() {
        super(WRONG_TEXT, WRONG_TEXT);
    }

    public DatePickerValidation(String wrongText) {
        super(wrongText, wrongText);
    }

    public DatePickerValidation(String wrongText, String detailedText) {
        super(wrongText, detailedText);
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }

    @Override
    public int hashCode() {
        return this.getClass().getCanonicalName().hashCode();
    }

}
