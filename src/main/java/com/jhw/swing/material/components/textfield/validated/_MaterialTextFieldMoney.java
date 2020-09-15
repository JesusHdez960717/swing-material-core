/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textfield.validated;

import com.jhw.swing.material.components.textfield.MaterialFormatedTextField;
import com.jhw.swing.material.components.textfield._MaterialFormatedTextFieldRuntime;
import com.jhw.swing.util.Utils;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import com.jhw.utils.formateer.*;
import java.util.StringTokenizer;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextFieldMoney extends _MaterialFormatedTextFieldRuntime<BigDecimal> {

    public static MaterialFormatedTextField from() {
        return new _MaterialTextFieldMoney();
    }

    public static MaterialFormatedTextField from(boolean negative) {
        return new _MaterialTextFieldMoney(negative);
    }

    private static final String INCORRECTO = "Tipo de dato incorrecto";

    private boolean negative = false;

    public _MaterialTextFieldMoney() {
        this(false);
    }

    public _MaterialTextFieldMoney(boolean negative) {
        super(new MoneyFormateer(), BigDecimal.class);
        this.setMaxLength(20);
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
        try {
            this.commitEdit();
        } catch (Exception e) {
        }
        String originalText = getValue().toString();
        int caretPos = getCaretPosition() - new StringTokenizer(getText().trim(), MoneyFormateer.MIDDLE).countTokens() + 1;
        caretPos = Math.max(0, Math.min(caretPos, originalText.length()));

        text = (originalText.substring(0, caretPos) + ch + originalText.substring(caretPos, originalText.length()));
        if (negative && text.length() == 1 && text.contains("-")) {
            return BigDecimal.ZERO;
        }

        try {
            return new BigDecimal(text.replace(",", "."));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public BigDecimal getObject() {
        try {
            return new BigDecimal(getValue().toString().replace(",", "."));
        } catch (Exception e) {
            wrong(INCORRECTO);
            return null;
            //throw new RuntimeException(INCORRECTO);
        }
    }

}
