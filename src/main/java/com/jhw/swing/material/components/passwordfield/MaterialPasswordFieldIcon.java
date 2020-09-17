/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.passwordfield;

import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.effects.Iconable;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MaterialPasswordFieldIcon extends _PanelTransparent implements Iconable, MaterialPasswordFieldDefinition {

    public abstract MaterialPasswordField getPasswordField();
}
