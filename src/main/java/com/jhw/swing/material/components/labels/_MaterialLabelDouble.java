/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.labels;

import com.jhw.utils.interfaces.Update;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialLabelDouble extends MaterialLabelDoble implements Update {

    public static _MaterialLabelDouble from() {
        return new _MaterialLabelDouble();
    }

    protected _MaterialLabelDouble() {
        initComponents();
    }

    private void initComponents() {
        labelLeft = MaterialLabelsFactory.build();
        labelLeft.setText("Left");
        labelLeft.setFont(labelLeft.getFont().deriveFont(18));

        labelRigth = MaterialLabelsFactory.build();
        labelRigth.setText("Rigth");
        labelRigth.setFont(labelRigth.getFont().deriveFont(20));
        labelRigth.setHorizontalAlignment(SwingConstants.RIGHT);
        update();
    }

    private MaterialLabel labelLeft;
    private MaterialLabel labelRigth;

    @Override
    public void update() {
        this.removeAll();
        this.setLayout(new BorderLayout());

        this.add(labelLeft, BorderLayout.WEST);
        this.add(labelRigth, BorderLayout.CENTER);
    }

    @Override
    public void setLeftText(String text) {
        this.labelLeft.setText(text);
    }

    @Override
    public void setRigthText(String text) {
        this.labelRigth.setText(text);
    }

    @Override
    public String getRigthText() {
        return labelRigth.getObject();
    }

    @Override
    public String getLeftText() {
        return labelLeft.getObject();
    }

    @Override
    public void setLabelRigth(MaterialLabel labelRigth) {
        this.labelRigth = labelRigth;
        this.labelRigth.setHorizontalAlignment(SwingConstants.TRAILING);
        update();
    }

    @Override
    public void setLabelLeft(MaterialLabel labelLeft) {
        this.labelLeft = labelLeft;
        this.labelLeft.setHorizontalAlignment(SwingConstants.LEADING);
        update();
    }

    public MaterialLabel getLabelRigth() {
        return labelRigth;
    }

    public MaterialLabel getLabelLeft() {
        return labelLeft;
    }

}
