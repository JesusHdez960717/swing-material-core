/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.combobox;

import javax.swing.*;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.material.effects.FloatingLabel;
import com.jhw.swing.material.effects.Line;
import com.jhw.swing.util.interfaces.BindableComponent;
import com.jhw.swing.material.effects.Wrong;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MaterialComboBox<T> extends JComboBox<T> implements Line, FloatingLabel, BindableComponent<T>, Wrong, MaterialComponent {

    public abstract void setModel(java.util.List<T> aModel);

}
