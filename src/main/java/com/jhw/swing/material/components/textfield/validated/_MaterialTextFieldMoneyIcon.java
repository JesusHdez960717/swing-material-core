/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textfield.validated;

import com.jhw.swing.material.components.textfield.MaterialFormatedTextField;
import com.jhw.swing.material.components.textfield._MaterialFormatedTextFieldIcon;
import com.jhw.swing.material.standards.MaterialIcons;
import java.math.BigDecimal;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextFieldMoneyIcon extends _MaterialFormatedTextFieldIcon<BigDecimal> {

    public static MaterialFormatedTextField from() {
        return new _MaterialTextFieldMoneyIcon();
    }

    public _MaterialTextFieldMoneyIcon() {
        this(false);
    }

    public _MaterialTextFieldMoneyIcon(boolean negative) {
        super(_MaterialTextFieldMoney.from(negative));
        setIcon(MaterialIcons.ATTACH_MONEY);
    }

}
