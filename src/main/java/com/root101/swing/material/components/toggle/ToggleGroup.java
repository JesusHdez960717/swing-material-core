/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.toggle;

import javax.swing.JToggleButton;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class ToggleGroup {

    public abstract void add(JToggleButton button);

    public abstract JToggleButton getSelected();
}
