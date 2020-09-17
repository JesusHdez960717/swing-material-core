/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textfield;

import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.effects.Iconable;

/**
 * this.setFormatterFactory(new DefaultFormatterFactory(formateer));
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MaterialFormatedTextFieldIcon<T> extends _PanelTransparent implements Iconable, MaterialFormatedTextFieldDefinition<T> {

    public abstract MaterialFormatedTextField getFormatedTextField();
}
