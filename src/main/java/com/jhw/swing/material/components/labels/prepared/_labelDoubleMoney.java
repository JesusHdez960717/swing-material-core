/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.labels.prepared;

import com.jhw.swing.material.components.labels._MaterialLabelDouble;
import com.jhw.swing.material.components.labels._MaterialLabelDoubleMoney;
import com.jhw.swing.material.standards.MaterialFontRoboto;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _labelDoubleMoney extends _MaterialLabelDouble implements _MaterialLabelDoubleMoney {

    public _labelDoubleMoney() {
        getLabelRigth().setFont(MaterialFontRoboto.BOLD.deriveFont(22f));
    }

    @Override
    public void setMoney(double value, Object coin) {
        getLabelRigth().setMoney(value, coin.toString());
    }

    @Override
    public void setText(String text) {
        setLeftText(text);
    }
}
