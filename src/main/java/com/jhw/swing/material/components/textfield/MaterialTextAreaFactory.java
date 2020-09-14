/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textfield;

import com.jhw.swing.material.components.textfield.validated.*;
import javax.swing.JFormattedTextField.AbstractFormatter;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialTextAreaFactory {

    public static MaterialTextField build() {
        return _MaterialTextField.from();
    }

    public static MaterialTextField buildIcon() {
        return _MaterialTextFieldIcon.from();
    }

    public static MaterialFormatedTextField buildFormated() {
        return _MaterialFormatedTextField.from();
    }

    public static MaterialFormatedTextField buildFormatedIcon() {
        return _MaterialFormatedTextFieldIcon.from();
    }

    public static MaterialFormatedTextField buildFormatedRuntime(AbstractFormatter formateer) {
        return _MaterialFormatedTextFieldRuntime.from(formateer);
    }

    public static MaterialFormatedTextField buildFormatedRuntime(AbstractFormatter formateer, Class clazz) {
        return _MaterialFormatedTextFieldRuntime.from(formateer, clazz);
    }

    public static MaterialFormatedTextField buildFormatedRuntimeIcon(AbstractFormatter formateer) {
        return _MaterialFormatedTextFieldRuntime.from(formateer);
    }

    public static MaterialFormatedTextField buildFormatedRuntimeIcon(AbstractFormatter formateer, Class clazz) {
        return _MaterialFormatedTextFieldRuntime.from(formateer, clazz);
    }

    public static MaterialFormatedTextField buildFormatedMoney() {
        return _MaterialTextFieldMoney.from();
    }

    public static MaterialFormatedTextField buildFormatedMoneyIcon() {
        return _MaterialTextFieldMoneyIcon.from();
    }
}
