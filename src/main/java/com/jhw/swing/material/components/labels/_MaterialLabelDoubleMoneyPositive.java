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
public class _MaterialLabelDoubleMoneyPositive extends _MaterialLabelDoubleMoney {

    public static _MaterialLabelDoubleMoneyPositive from() {
        return new _MaterialLabelDoubleMoneyPositive();
    }

    public _MaterialLabelDoubleMoneyPositive() {
        setLabelRigth(posit);
        posit.setFont(MaterialFontRoboto.BOLD.deriveFont(20f));
    }

    private final _MaterialLabelPositive posit = new _MaterialLabelPositive();

    @Override
    public void setMoney(BigDecimal money, Object coin) {
        posit.setMoney(money, coin.toString());
    }
}
