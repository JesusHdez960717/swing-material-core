/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.combobox;

/**
 * Por el momento los combo boxes no necesitan injection ni proxy, no tiene
 * sentido usarlos y agregarle capas innecesarias a los componentes
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialComboBoxFactory {

    public static MaterialComboBox build() {
        return _MaterialComboBox.from();
    }

    public static MaterialComboBox buildFiltrable() {
        return _MaterialComboBoxFiltrable.from();
    }

    public static MaterialComboBoxIcon buildIcon() {
        return _MaterialComboBoxIcon.from();
    }

    public static MaterialComboBoxIcon buildFiltrableIcon() {
        return _MaterialComboBoxIcon.from(buildFiltrable());
    }
}
