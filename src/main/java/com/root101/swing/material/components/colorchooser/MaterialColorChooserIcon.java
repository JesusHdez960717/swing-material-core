/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.colorchooser;

import com.root101.swing.material.components.container.panel._PanelTransparent;
import com.root101.swing.material.effects.Iconable;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MaterialColorChooserIcon extends _PanelTransparent implements MaterialColorChooserDefinition, Iconable {

    public abstract MaterialColorChooser getColorChooser();
}
