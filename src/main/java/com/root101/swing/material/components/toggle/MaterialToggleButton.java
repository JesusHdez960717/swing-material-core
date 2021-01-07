/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.toggle;

import com.root101.swing.util.interfaces.BindableComponent;
import com.root101.swing.util.interfaces.MaterialComponent;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MaterialToggleButton extends JToggleButton implements BindableComponent<Boolean>, MaterialComponent {

    public abstract ImageIcon getUnselectedIcon();

    public abstract void setUnselectedIcon(ImageIcon unselectedIcon);

    public abstract ImageIcon getSelectedIcon();

    public abstract void setSelectedIcon(ImageIcon selectedIcon);
}
