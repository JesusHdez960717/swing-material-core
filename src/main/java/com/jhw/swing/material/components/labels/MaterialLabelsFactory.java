/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.labels;

import com.jhw.swing.material.injection.MaterialSwingInjector;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialLabelsFactory {

    public static MaterialLabel build() {
        return _MaterialLabel.from();
    }

    public static MaterialLabelMoney buildMoney() {
        return _MaterialLabelMoney.from();
    }

    public static MaterialLabelMoney buildMoneyNegative() {
        return _MaterialLabelNegative.from();
    }

    public static MaterialLabelMoney buildMoneyPositive() {
        return _MaterialLabelPositive.from();
    }

    public static MaterialLabelDoble buildDouble() {
        return _MaterialLabelDouble.from();
    }

    public static MaterialLabelDobleMoney buildDoubleMoney() {
        return _MaterialLabelDoubleMoney.from();
    }

    public static MaterialLabelDobleMoney buildDoubleMoneyNegative() {
        return _MaterialLabelDoubleMoneyNegative.from();
    }

    public static MaterialLabelDobleMoney buildDoubleMoneyPositive() {
        return _MaterialLabelDoubleMoneyPositive.from();
    }

}
