/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.combobox;

import com.jhw.swing.material.effects.FloatingLabel;
import com.jhw.swing.material.effects.Line;
import com.jhw.swing.material.effects.Wrong;
import com.jhw.swing.util.interfaces.BindableComponent;
import com.jhw.swing.util.interfaces.MaterialComponent;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface MaterialComboBoxDefinition<T> extends Line, FloatingLabel, BindableComponent<T>, Wrong, MaterialComponent {

    public default void setModel(java.util.List<T> aModel) {
        setModel(new DefaultComboBoxModel(aModel.toArray(new Object[aModel.size()])));
        setObject(null);
    }

    public default void clear() {
        setObject(null);
    }

    public void setModel(ComboBoxModel<T> aModel);
}
