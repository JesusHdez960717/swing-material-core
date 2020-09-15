/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.container.panel;

import com.jhw.swing.material.effects.Iconable;
import com.jhw.swing.material.effects.MaterialLineBorder;
import com.jhw.swing.util.interfaces.MaterialComponent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MaterialPanelBorder extends JPanel implements Iconable, MaterialLineBorder, MaterialComponent, PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        firePropertyChange(evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
    }
}
