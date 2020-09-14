package com.jhw.swing.material.components.textfield.validated;

import com.jhw.swing.material.components.textfield.MaterialFormatedTextField;
import com.jhw.swing.material.components.textfield.MaterialTextField;
import com.jhw.swing.material.components.textfield._MaterialTextField;
import com.jhw.swing.util.Utils;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextFieldDouble extends _MaterialTextField<Double> {

    public static MaterialTextField from() {
        return new _MaterialTextFieldDouble();
    }
    
    public static MaterialTextField from(boolean negative) {
        return new _MaterialTextFieldDouble(negative);
    }
    
    private boolean negative = false;

    public _MaterialTextFieldDouble() {
        this(false);
    }

    public _MaterialTextFieldDouble(boolean negative) {
        super(Double.class);
        this.negative = negative;
        addListeners();
    }

    private void addListeners() {
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if (validateText(evt.getKeyChar()) == null) {
                    Utils.beep();
                    evt.consume();
                }
            }
        });
    }

    private Object validateText(char c) {
        String text;

        if (c == (char) KeyEvent.VK_BACK_SPACE || c == (char) KeyEvent.VK_DELETE) {
            c = ' ';
        } else if (!Character.isDigit(c) && c != (char) KeyEvent.VK_MINUS && c != KeyEvent.VK_COMMA && c != KeyEvent.VK_PERIOD) {//si no es un digito o el + o el espacio de arribo, ERROR 
            return null;
        }
        String ch = (c + "").trim();
        text = (getText().substring(0, getCaretPosition()) + ch + getText().substring(getCaretPosition(), getText().length()));
        if (negative && text.length() == 1 && text.contains("-")) {
            return 0d;
        }

        try {
            return Double.parseDouble(text);
        } catch (Exception e) {
            return null;
        }
    }
}
