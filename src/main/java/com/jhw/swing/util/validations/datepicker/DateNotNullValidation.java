package com.jhw.swing.util.validations.datepicker;

import com.jhw.swing.util.interfaces.DateSelected;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DateNotNullValidation extends DatePickerValidation<DateSelected> {

    public static final String WRONG_TEXT = "Seleccione una fecha";

    public DateNotNullValidation() {
        super(WRONG_TEXT, WRONG_TEXT);
    }

    public DateNotNullValidation(String wrongText) {
        super(wrongText, wrongText);
    }

    public DateNotNullValidation(String wrongText, String detailedText) {
        super(wrongText, detailedText);
    }

    @Override
    public boolean validate(DateSelected obj) {
        return obj.getDate() != null;
    }

}
