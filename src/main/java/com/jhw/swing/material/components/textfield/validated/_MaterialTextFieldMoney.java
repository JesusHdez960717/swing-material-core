/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textfield.validated;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextFieldMoney extends _MaterialTextFieldDouble {

    public _MaterialTextFieldMoney() {
        this(false);
        this.setFrontText("$");
    }

    public _MaterialTextFieldMoney(boolean negative) {
        super(negative);
    }

}
