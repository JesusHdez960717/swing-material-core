/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.progress;

import com.jhw.swing.util.interfaces.MaterialComponent;
import javax.swing.JComponent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MaterialProgressSpinner extends JComponent implements MaterialComponent {

    public abstract int getThickness();

    public abstract void setThickness(int thickness);
}
