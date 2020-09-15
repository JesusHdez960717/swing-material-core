/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.labels;

import com.jhw.swing.material.components.container.panel._PanelTransparent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class MaterialLabelDoble extends _PanelTransparent {

    public abstract void setLeftText(String text);

    public abstract void setRigthText(String text);

    public abstract String getRigthText();

    public abstract String getLeftText();

    public abstract void setLabelLeft(MaterialLabel labelLeft);

    public abstract void setLabelRigth(MaterialLabel labelRigth);

}
