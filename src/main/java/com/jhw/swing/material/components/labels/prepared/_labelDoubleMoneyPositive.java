/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.labels.prepared;

import com.jhw.swing.material.components.labels._MaterialLabelDouble;
import com.jhw.swing.material.components.labels._MaterialLabelDoubleMoney;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import java.math.BigDecimal;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _labelDoubleMoneyPositive extends _MaterialLabelDouble implements _MaterialLabelDoubleMoney {

    public _labelDoubleMoneyPositive() {
        positive.setFont(MaterialFontRoboto.BOLD.deriveFont(20f));
        super.setLabelRigth(positive);
    }
    private final _labelPositive positive = new _labelPositive();

    @Override
    public void setMoney(BigDecimal money, Object coin) {
        positive.setMoney(money, coin.toString());
    }

    @Override
    public void setText(String text) {
        setLeftText(text);
    }
}
