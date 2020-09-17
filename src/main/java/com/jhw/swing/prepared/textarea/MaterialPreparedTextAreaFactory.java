/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.prepared.textarea;

import com.jhw.swing.material.components.textarea.MaterialTextArea;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialPreparedTextAreaFactory {

    public static MaterialTextArea buildDescripcion() {
        return _MaterialTextAreaDescripcion.from();
    }
}
