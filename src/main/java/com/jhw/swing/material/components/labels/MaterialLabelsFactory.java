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
        return MaterialSwingInjector.getImplementation(_MaterialLabel.class);
    }

    public static MaterialLabelMoney buildMoney() {
        return MaterialSwingInjector.getImplementation(_MaterialLabelMoney.class);
    }

    public static MaterialLabelMoney buildMoneyPositive() {
        return MaterialSwingInjector.getImplementation(_MaterialLabelPositive.class);
    }

    public static MaterialLabelMoney buildMoneyNegative() {
        return MaterialSwingInjector.getImplementation(_MaterialLabelNegative.class);
    }

    public static MaterialLabelDoble buildDouble() {
        return MaterialSwingInjector.getImplementation(_MaterialLabelDouble.class);
    }

    public static MaterialLabelDobleMoney buildDoubleMoney() {
        return MaterialSwingInjector.getImplementation(_MaterialLabelDoubleMoney.class);
    }

    public static MaterialLabelDobleMoney buildDoubleMoneyPositive() {
        return MaterialSwingInjector.getImplementation(_MaterialLabelDoubleMoneyPositive.class);
    }

    public static MaterialLabelDobleMoney buildDoubleMoneyNegative() {
        return MaterialSwingInjector.getImplementation(_MaterialLabelDoubleMoneyNegative.class);
    }
}
