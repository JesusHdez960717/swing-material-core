/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.util;

import com.jhw.module.util.personalization.core.domain.Personalization;
import com.jhw.module.util.personalization.services.PersonalizationHandler;
import javax.swing.ToolTipManager;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
