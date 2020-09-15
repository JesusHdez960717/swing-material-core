/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.scrollpane;

import com.jhw.swing.material.effects.BorderDinamic;
import javax.swing.JScrollPane;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MaterialScrollPane extends JScrollPane implements BorderDinamic{

    public abstract MaterialScrollBar getMaterialVerticalScrollBar();

    public abstract MaterialScrollBar getMaterialHorizontalScrollBar();

}
