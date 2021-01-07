/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.util;

import com.jhw.module.util.personalization.core.domain.Personalization;
import com.jhw.module.util.personalization.services.PersonalizationHandler;
import javax.swing.ToolTipManager;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class PersonalizationMaterial {

    private static final String INIT = init();

    public static final String KEY_SHOW_ICON_INPUT = INIT + "boolean.show_icon_input";
    public static final Object VALUE_SHOW_ICON_INPUT = true;

    public static final String KEY_FORMAT_TEXT_FIELD_RUNTIME = INIT + "boolean.format_text_fields";
    public static final Object VALUE_FORMAT_TEXT_FIELD_RUNTIME = true;

    static {
        PersonalizationHandler.putObjectIfNotContain(KEY_SHOW_ICON_INPUT, VALUE_SHOW_ICON_INPUT);
        PersonalizationHandler.putObjectIfNotContain(KEY_FORMAT_TEXT_FIELD_RUNTIME, VALUE_FORMAT_TEXT_FIELD_RUNTIME);
    }

    private static String init() {
        return "material_personalization.key.";
    }

    public static void setUpInitialGlobal() {
        ToolTipManager.sharedInstance().setInitialDelay(PersonalizationHandler.getInt(Personalization.KEY_INT_TOOLTIP_INITIAL_DELAY));
        ToolTipManager.sharedInstance().setDismissDelay(PersonalizationHandler.getInt(Personalization.KEY_INT_TOOLTIP_DISMISS_DELAY));
    }
}
