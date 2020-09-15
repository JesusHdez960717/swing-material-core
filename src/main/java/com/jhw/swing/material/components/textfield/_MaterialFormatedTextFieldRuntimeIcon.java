/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textfield;

import com.jhw.swing.material.standards.MaterialIcons;
import java.math.BigDecimal;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialFormatedTextFieldRuntimeIcon extends _MaterialFormatedTextFieldIcon<BigDecimal> {

    public static MaterialFormatedTextField from(AbstractFormatter formateer) {
        return new _MaterialFormatedTextFieldRuntimeIcon(formateer);
    }

    public static MaterialFormatedTextField from(AbstractFormatter formateer, Class clazz) {
        return new _MaterialFormatedTextFieldRuntimeIcon(formateer, clazz);
    }

    public _MaterialFormatedTextFieldRuntimeIcon(AbstractFormatter formateer) {
        super(_MaterialFormatedTextFieldRuntime.from(formateer, String.class));
        setIcon(MaterialIcons.EDIT);
    }

    public _MaterialFormatedTextFieldRuntimeIcon(AbstractFormatter formateer, Class clazz) {
        super(_MaterialFormatedTextFieldRuntime.from(formateer, clazz));
        setIcon(MaterialIcons.EDIT);
    }

}
