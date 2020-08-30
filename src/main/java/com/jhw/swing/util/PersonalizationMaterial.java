/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.util;

import com.jhw.personalization.services.PersonalizationHandler;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class PersonalizationMaterial {

    private static final String INIT = init();
    public static final String KEY_SHOW_ICON_INPUT = INIT + "boolean.show_icon_input";
    public static final Object VALUE_SHOW_ICON_INPUT = true;

    static {
        PersonalizationHandler.putObjectIfNotContain(KEY_SHOW_ICON_INPUT, VALUE_SHOW_ICON_INPUT);
    }

    private static String init() {
        return "material_personalization.key.";
    }
}
