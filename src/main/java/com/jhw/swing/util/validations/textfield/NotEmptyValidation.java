package com.jhw.swing.util.validations.textfield;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class NotEmptyValidation extends TextFieldValidation<String> {

    public static final String WRONG_TEXT = "NO puede estar en blanco";

    public NotEmptyValidation() {
        super(WRONG_TEXT, WRONG_TEXT);
    }

    public NotEmptyValidation(String wrongText) {
        super(wrongText, wrongText);
    }

    public NotEmptyValidation(String wrongText, String detailedText) {
        super(wrongText, detailedText);
    }

    @Override
    public boolean validate(String obj) {
        return !obj.isEmpty();
    }

}
