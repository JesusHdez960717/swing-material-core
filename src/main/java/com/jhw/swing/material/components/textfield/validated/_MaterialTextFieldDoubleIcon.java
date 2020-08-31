/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textfield.validated;

import com.jhw.swing.material.components.textfield._MaterialTextFieldIcon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextFieldDoubleIcon extends _MaterialTextFieldIcon<Double> {

    public _MaterialTextFieldDoubleIcon() {
        this(false);
    }

    public _MaterialTextFieldDoubleIcon(boolean negative) {
        super(new _MaterialTextFieldDouble(negative));
    }

}
