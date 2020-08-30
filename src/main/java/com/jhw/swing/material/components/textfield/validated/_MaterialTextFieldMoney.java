/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textfield.validated;

import com.jhw.swing.material.components.textfield._MaterialTextField;
import com.jhw.swing.util.Utils;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextFieldMoney extends _MaterialTextField<BigDecimal> {

    private boolean negative = false;

    public _MaterialTextFieldMoney() {
        this(false);
    }

    public _MaterialTextFieldMoney(boolean negative) {
        super(BigDecimal.class);
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
        text = (getText().substring(0, getCaretPosition()) + ch + getText().substring(getCaretPosition(), getText().length()));
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
            return new BigDecimal(getText().replace(",", "."));
        } catch (Exception e) {
            throw new RuntimeException("Tipo de dato incorrecto");
        }
    }

}
