/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textarea;

import com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialTextAreaFactory {

    public static _MaterialTextArea build() {
        return _MaterialTextArea.from();
    }

    public static ContentArea buildContentArea() {
        return DefaultContentArea.from();
    }

    public static MaterialTextArea buildDescripcion() {
        return _MaterialTextAreaDescripcion.from();
    }
}
