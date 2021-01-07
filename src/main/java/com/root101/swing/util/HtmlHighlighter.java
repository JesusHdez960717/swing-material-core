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
import java.util.regex.Pattern;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class HtmlHighlighter {

    private static final String HIGH_LIGHT_TEMPLATE = "<span style='background:yellow;'>$1</span>";

    public static String highlightText(String text, String textToHighlight) {
        if (!PersonalizationHandler.getBoolean(Personalization.KEY_USE_ANIMATIONS)) {
            return text;
        }
        if (textToHighlight.length() == 0) {
            return text;
        }
        try {
            text = text.replaceAll("(?i)(" + Pattern.quote(textToHighlight) + ")", HIGH_LIGHT_TEMPLATE);
        } catch (Exception e) {
            return text;
        }
        return "<html>" + text + "</html>";
    }
}
