/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.passwordfield;

import com.jhw.swing.material.components.textfield.TextExtra;
import com.jhw.swing.material.components.textfield.TextMaxLength;
import com.jhw.swing.material.effects.FloatingLabel;
import com.jhw.swing.material.effects.Iconable;
import com.jhw.swing.material.effects.Line;
import com.jhw.swing.material.effects.Wrong;
import com.jhw.swing.util.interfaces.BindableComponent;
import com.jhw.swing.util.interfaces.MaterialComponent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface MaterialPasswordFieldDefinition extends TextMaxLength, TextExtra, Line, BindableComponent<char[]>, Wrong, MaterialComponent, FloatingLabel {

    public void setText(String s);

    public String getHashAlgorithm();

    public void setHashAlgorithm(String hashAlgorithm);

    public MaterialPasswordField getPasswordField();
}
