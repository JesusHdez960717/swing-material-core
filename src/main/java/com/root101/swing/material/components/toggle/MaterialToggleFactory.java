/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.toggle;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialToggleFactory {

    public static ToggleGroup buildGroup() {
        return DefaultToggleGroup.from();
    }

    public static MaterialToggleButton buildButton() {
        return _MaterialToggleButton.from();
    }

    public static MaterialToggleButton buildRadioButton() {
        return _MaterialRadioButton.from();
    }

    public static MaterialToggleButton buildCheckBox() {
        return _MaterialCheckBox.from();
    }
}
