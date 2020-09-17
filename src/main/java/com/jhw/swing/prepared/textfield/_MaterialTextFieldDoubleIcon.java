/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.prepared.textfield;

import com.jhw.swing.material.components.textfield.MaterialTextFieldIcon;
import com.jhw.swing.material.components.textfield._MaterialTextFieldIcon;
import com.jhw.swing.material.standards.MaterialIcons;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextFieldDoubleIcon extends _MaterialTextFieldIcon<Double> {

    public static MaterialTextFieldIcon from() {
        return new _MaterialTextFieldDoubleIcon();
    }

    public static MaterialTextFieldIcon from(boolean negative) {
        return new _MaterialTextFieldDoubleIcon(negative);
    }

    public _MaterialTextFieldDoubleIcon() {
        this(false);
    }

    public _MaterialTextFieldDoubleIcon(boolean negative) {
        super(_MaterialTextFieldDouble.from(negative));
        this.setIcon(MaterialIcons.EDIT);
    }

}
