/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.labels;

import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.utils.interfaces.Update;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialLabelDouble extends _PanelTransparent implements Update {

    public _MaterialLabelDouble() {
        initComponents();
        update();
    }

    private void initComponents() {
        labelLeft = new _MaterialLabel();
        labelLeft.setText("Left");

        labelRigth = new _MaterialLabel();
        labelRigth.setText("Rigth");
        labelRigth.setHorizontalAlignment(SwingConstants.RIGHT);
    }
    private _MaterialLabel labelLeft;
    private _MaterialLabel labelRigth;

    @Override
    public void update() {
        this.removeAll();
        this.setLayout(new BorderLayout());

        this.add(labelLeft, BorderLayout.WEST);
        this.add(labelRigth, BorderLayout.CENTER);
    }

    public void setLeftText(String text) {
        this.labelLeft.setText(text);
    }

    public void setRigthText(String text) {
        this.labelRigth.setText(text);
    }

    public _MaterialLabel getLabelLeft() {
        return labelLeft;
    }

    public void setLabelLeft(_MaterialLabel labelLeft) {
        this.labelLeft = labelLeft;
        this.labelLeft.setHorizontalAlignment(SwingConstants.LEADING);
        update();
    }

    public _MaterialLabel getLabelRigth() {
        return labelRigth;
    }

    public void setLabelRigth(_MaterialLabel labelRigth) {
        this.labelRigth = labelRigth;
        this.labelRigth.setHorizontalAlignment(SwingConstants.TRAILING);
        update();
    }

}
