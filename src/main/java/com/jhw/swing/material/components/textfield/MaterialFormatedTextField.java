/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textfield;

import com.jhw.swing.material.effects.FloatingLabel;
import com.jhw.swing.material.effects.Iconable;
import com.jhw.swing.material.effects.Line;
import com.jhw.swing.material.effects.Wrong;
import com.jhw.swing.util.interfaces.BindableComponent;
import com.jhw.swing.util.interfaces.MaterialComponent;
import javax.swing.JFormattedTextField;

/**
 * this.setFormatterFactory(new DefaultFormatterFactory(formateer));
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MaterialFormatedTextField<T> extends JFormattedTextField implements Iconable, TextExtra, TextMaxLength, Line, BindableComponent<T>, Wrong, MaterialComponent, FloatingLabel {

    public abstract MaterialFormatedTextField getFormatedTextField();
}
