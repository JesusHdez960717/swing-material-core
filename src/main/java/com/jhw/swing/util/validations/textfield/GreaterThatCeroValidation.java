package com.jhw.swing.util.validations.textfield;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GreaterThatCeroValidation extends TextFieldValidation<Object> {

    public static final String WRONG_TEXT = "Fuera de rango";

    public GreaterThatCeroValidation() {
        super(WRONG_TEXT, WRONG_TEXT);
    }

    public GreaterThatCeroValidation(String wrongText) {
        super(wrongText, wrongText);
    }

    public GreaterThatCeroValidation(String wrongText, String detailedText) {
        super(wrongText, detailedText);
    }

    @Override
    public boolean validate(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj) > 0;
        } else if (obj instanceof Long) {
            return ((Long) obj) > 0;
        } else if (obj instanceof Float) {
            return ((Float) obj) > 0;
        } else if (obj instanceof Double) {
            return ((Double) obj) > 0;
        }
        return false;
    }

}
