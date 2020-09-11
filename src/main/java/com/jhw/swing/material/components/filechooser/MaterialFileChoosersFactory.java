/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.filechooser;

import com.jhw.swing.material.components.datepicker.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialFileChoosersFactory {

    public static MaterialFileChooser build() {
        return _MaterialFileChooser.from();
    }

    public static MaterialFileChooser buildIcon() {
        return _MaterialFileChooserIcon.from();
    }
}
