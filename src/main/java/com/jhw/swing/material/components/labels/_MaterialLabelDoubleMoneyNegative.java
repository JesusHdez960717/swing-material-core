/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.labels;

import com.jhw.swing.material.standards.MaterialFontRoboto;
import java.math.BigDecimal;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialLabelDoubleMoneyNegative extends _MaterialLabelDoubleMoney {

    public static _MaterialLabelDoubleMoneyNegative from() {
        return new _MaterialLabelDoubleMoneyNegative();
    }

    public _MaterialLabelDoubleMoneyNegative() {
        super.setLabelRigth(negative);
        negative.setFont(MaterialFontRoboto.BOLD.deriveFont(20f));
    }

    private final _MaterialLabelNegative negative = new _MaterialLabelNegative();

    @Override
    public void setMoney(BigDecimal money, Object coin) {
        negative.setMoney(money, coin.toString());
    }

}
