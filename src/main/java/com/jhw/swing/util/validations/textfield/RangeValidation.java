package com.jhw.swing.util.validations.textfield;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RangeValidation extends TextFieldValidation<Object> {

    public static final String WRONG_TEXT = "NO puede ser negativo";

    private final Object low;
    private final Object top;

    public RangeValidation(Object low, Object top) {
        super(WRONG_TEXT, WRONG_TEXT);
        this.low = low;
        this.top = top;
    }

    public RangeValidation(Object low, Object top, String wrongText) {
        super(wrongText, wrongText);
        this.low = low;
        this.top = top;
    }

    public RangeValidation(Object low, Object top, String wrongText, String detailedText) {
        super(wrongText, detailedText);
        this.low = low;
        this.top = top;
    }

    @Override
    public boolean validate(Object obj) {
        if (obj instanceof Integer) {
            int val = (Integer) obj;
            return val >= (Integer) low && val <= (Integer) top;
        } else if (obj instanceof Long) {
            long val = (Long) obj;
            return val >= (Long) low && val <= (Long) top;
        } else if (obj instanceof Float) {
            float val = (Float) obj;
            return val >= (Float) low && val <= (Float) top;
        } else if (obj instanceof Double) {
            double val = (Double) obj;
            return val >= (Double) low && val <= (Double) top;
        }
        return false;
    }

}
