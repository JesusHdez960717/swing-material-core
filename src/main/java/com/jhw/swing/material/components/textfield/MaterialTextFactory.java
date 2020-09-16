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
public class MaterialTextFactory {

    public static MaterialTextField build() {
        return _MaterialTextField.from();
    }

    public static MaterialTextFieldIcon buildIcon() {
        return _MaterialTextFieldIcon.from();
    }

    public static MaterialFormatedTextField buildFormated() {
        return _MaterialFormatedTextField.from();
    }

    public static MaterialFormatedTextFieldIcon buildFormatedIcon() {
        return _MaterialFormatedTextFieldIcon.from();
    }

    public static MaterialFormatedTextField buildFormatedRuntime(AbstractFormatter formateer) {
        return _MaterialFormatedTextFieldRuntime.from(formateer);
    }

    public static MaterialFormatedTextField buildFormatedRuntime(AbstractFormatter formateer, Class clazz) {
        return _MaterialFormatedTextFieldRuntime.from(formateer, clazz);
    }

    public static MaterialFormatedTextFieldIcon buildFormatedRuntimeIcon(AbstractFormatter formateer) {
        return _MaterialFormatedTextFieldRuntimeIcon.from(formateer);
    }

    public static MaterialFormatedTextFieldIcon buildFormatedRuntimeIcon(AbstractFormatter formateer, Class clazz) {
        return _MaterialFormatedTextFieldRuntimeIcon.from(formateer, clazz);
    }

    public static MaterialFormatedTextField buildFormatedMoney() {
        return _MaterialTextFieldMoney.from();
    }

    public static MaterialFormatedTextFieldIcon buildFormatedMoneyIcon() {
        return _MaterialTextFieldMoneyIcon.from();
    }

    public static MaterialTextField buildDouble() {
        return _MaterialTextFieldDouble.from();
    }

    public static MaterialTextFieldIcon buildDoubleIcon() {
        return _MaterialTextFieldDoubleIcon.from();
    }

    public static MaterialTextField buildInteger() {
        return _MaterialTextFieldInteger.from();
    }

    public static MaterialTextFieldIcon buildIntegerIcon() {
        return _MaterialTextFieldIntegerIcon.from();
    }
}
