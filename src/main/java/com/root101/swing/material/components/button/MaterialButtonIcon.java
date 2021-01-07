/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.button;

import com.root101.swing.material.effects.Iconable;
import com.root101.swing.material.effects.RippleEffect;
import com.root101.swing.util.interfaces.MaterialComponent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MaterialButtonIcon extends JButton implements Iconable, RippleEffect, MaterialComponent, PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        firePropertyChange(evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
    }
}
