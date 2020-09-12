/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.passwordfield;

import com.jhw.swing.material.effects.FloatingLabel;
import com.jhw.swing.material.effects.Iconable;
import com.jhw.swing.material.effects.Line;
import com.jhw.swing.material.effects.Wrong;
import com.jhw.swing.util.interfaces.BindableComponent;
import com.jhw.swing.util.interfaces.MaterialComponent;
import javax.swing.JPasswordField;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MaterialPasswordField extends JPasswordField implements Iconable, Line, BindableComponent<char[]>, Wrong, MaterialComponent, FloatingLabel {

    public abstract int getMaxLength();

    public abstract void setMaxLength(int maxLength);

    public abstract String getExtra();

    public abstract void setExtra(String extra);

    public abstract String getHashAlgorithm();

    public abstract void setHashAlgorithm(String hashAlgorithm);
}
