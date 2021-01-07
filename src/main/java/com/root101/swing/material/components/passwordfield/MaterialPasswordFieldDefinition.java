/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.passwordfield;

import com.root101.swing.material.components.textfield.TextExtra;
import com.root101.swing.material.components.textfield.TextMaxLength;
import com.root101.swing.material.effects.FloatingLabel;
import com.root101.swing.material.effects.Iconable;
import com.root101.swing.material.effects.Line;
import com.root101.swing.material.effects.Wrong;
import com.root101.swing.util.interfaces.BindableComponent;
import com.root101.swing.util.interfaces.MaterialComponent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface MaterialPasswordFieldDefinition extends TextMaxLength, TextExtra, Line, BindableComponent<String>, Wrong, MaterialComponent, FloatingLabel {

    public void setText(String s);

}
