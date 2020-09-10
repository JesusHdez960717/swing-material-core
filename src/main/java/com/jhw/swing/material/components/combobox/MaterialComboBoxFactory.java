/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.combobox;

import javax.swing.JComboBox;

/**
 * Por el momento los combo boxes no necesitan injection ni proxy, no tiene sentido
 * usarlos y agregarle capas innecesarias a los componentes
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialComboBoxFactory {

    public static JComboBox build() {
        //return MaterialSwingInjector.getImplementation(_MaterialComboBox.class);
        return _MaterialComboBox.from();
    }

    public static JComboBox buildFiltrable() {
        //return MaterialSwingInjector.getImplementation(_MaterialComboBoxFiltrable.class);
        return _MaterialComboBoxFiltrable.from();
    }

}
