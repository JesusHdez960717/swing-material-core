/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.textfield;

import javax.swing.JFormattedTextField.AbstractFormatter;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialTextFactory {

    public static MaterialTextField build() {
        return _MaterialTextField.from();
    }

    public static MaterialTextField build(Class clazz) {
        return _MaterialTextField.from(clazz);
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
}
