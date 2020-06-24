package com.jhw.swing.util.validations.icbs;

import com.jhw.swing.util.validations.Validation;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class ICBSValidation<T> extends Validation<T> {

    public static final String WRONG_TEXT = "Error en este campo de seleccion";

    public ICBSValidation() {
        super(WRONG_TEXT, WRONG_TEXT);
    }

    public ICBSValidation(String wrongText) {
        super(wrongText, wrongText);
    }

    public ICBSValidation(String wrongText, String detailedText) {
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
