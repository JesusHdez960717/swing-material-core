/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.colorchooser;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialColorChooserFactory {

    public static final MaterialColorChooser build() {
        return _MaterialColorChooser.from();
    }

    public static final MaterialColorChooserIcon buildIcon() {
        return _MaterialColorChooserIcon.from();
    }
}
