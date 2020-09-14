/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textfield;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialTextAreaFactory {

    public static MaterialTextField build() {
        return _MaterialTextField.from();
    }

    public static MaterialTextField buildIcon() {
        return _MaterialTextFieldIcon.from();
    }
}
