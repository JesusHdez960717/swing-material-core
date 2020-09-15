/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.scrollpane;

import java.awt.Color;
import javax.swing.JScrollBar;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MaterialScrollBar extends JScrollBar {

    public MaterialScrollBar(int orientation) {
        super(orientation);
    }

    public abstract Color getBackgroundThumb();

    public abstract void setBackgroundThumb(Color background);

    public abstract Color getForegroundThumb();

    public abstract void setForegroundThumb(Color foreground);

    public abstract int getThumbWidth();

}
