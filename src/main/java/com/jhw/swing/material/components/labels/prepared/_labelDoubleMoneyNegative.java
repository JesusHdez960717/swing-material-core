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
public class _labelDoubleMoneyNegative extends _MaterialLabelDouble implements _MaterialLabelDoubleMoney {

    public _labelDoubleMoneyNegative() {
        negative.setFont(MaterialFontRoboto.BOLD.deriveFont(20f));
        super.setLabelRigth(negative);
    }
    private final _labelNegativo negative = new _labelNegativo();

    @Override
    public void setMoney(double money, Object coin) {
        negative.setMoney(money, coin.toString());
    }

    @Override
    public void setText(String text) {
        setLeftText(text);
    }
}
