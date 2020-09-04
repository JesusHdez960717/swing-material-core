package com.jhw.swing.util;

import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import java.util.regex.Pattern;

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
