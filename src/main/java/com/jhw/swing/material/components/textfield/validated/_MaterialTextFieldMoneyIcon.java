/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textfield.validated;

import com.jhw.swing.material.components.textfield._MaterialTextFieldIcon;
import com.jhw.swing.material.standards.MaterialIcons;
import java.math.BigDecimal;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextFieldMoneyIcon extends _MaterialTextFieldIcon<BigDecimal> {

    public _MaterialTextFieldMoneyIcon() {
        this(false);
    }

    public _MaterialTextFieldMoneyIcon(boolean negative) {
        super(new _MaterialTextFieldMoney(negative));
        setIcon(MaterialIcons.ATTACH_MONEY);
    }

}
