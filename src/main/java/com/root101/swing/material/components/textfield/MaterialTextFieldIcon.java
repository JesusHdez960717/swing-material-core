/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.textfield;

import com.root101.swing.material.components.container.panel._PanelTransparent;
import com.root101.swing.material.effects.Iconable;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MaterialTextFieldIcon<T> extends _PanelTransparent implements Iconable, MaterialTextFieldDefinition<T> {

    public abstract MaterialTextField getTextField();
}
