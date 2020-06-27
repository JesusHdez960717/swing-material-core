package com.jhw.swing.util.validations.textfield;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class LengthExactValidation extends TextFieldValidation<String> {

    public static final String WRONG_TEXT = "Tamaño incorrecto";

    private final int tam;

    public LengthExactValidation(int tam) {
        super(WRONG_TEXT, WRONG_TEXT);
        this.tam = tam;
    }

    public LengthExactValidation(int tam, String wrongText) {
        super(wrongText, wrongText);
        this.tam = tam;
    }

    public LengthExactValidation(int tam, String wrongText, String detailedText) {
        super(wrongText, detailedText);
        this.tam = tam;
    }

    @Override
    public boolean validate(String obj) {
        return obj.length() == tam;
    }

}
