package com.jhw.swing.util.validations;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class Validation<T> {

    protected String wrongText = "Validación por defecto";
    protected String detailedText = wrongText;

    public Validation(String wrongText, String detailedText) {
        this.wrongText = wrongText;
        this.detailedText = detailedText;
    }

    public String getWrongText() {
        return wrongText;
    }

    public void setWrongText(String wrongText) {
        this.wrongText = wrongText;
    }

    public String getDetailedText() {
        return detailedText;
    }

    public void setDetailedText(String detailedText) {
        this.detailedText = detailedText;
    }

    public abstract boolean validate(T obj);
}
