/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.datepicker;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialDatePickersFactory {

    public static MaterialDatePicker build() {
        return _MaterialDatePicker.from();
    }

    public static MaterialDatePickerIcon buildIcon() {
        return _MaterialDatePickerIcon.from();
    }
}
