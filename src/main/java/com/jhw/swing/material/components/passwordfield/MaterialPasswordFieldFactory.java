/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.passwordfield;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialPasswordFieldFactory {

    public static MaterialPasswordField build() {
        return _MaterialPasswordField.from();
    }

    public static MaterialPasswordField buildIcon() {
        return _MaterialPasswordFieldIcon.from();
    }
}
