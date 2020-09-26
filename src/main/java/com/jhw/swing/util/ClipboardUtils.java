/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.util;

import com.clean.core.app.services.Notification;
import com.clean.core.app.services.NotificationsGeneralType;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ClipboardUtils {

    public static void copy(String textToCopy) {
        Toolkit.getDefaultToolkit()
                .getSystemClipboard()
                .setContents(
                        new StringSelection(textToCopy),
                        null
                );
        String text = "\"" + textToCopy + "\" copiado al portapapeles";
        Notification.showNotification(NotificationsGeneralType.NOTIFICATION_SIMPLE_TEXT, text);
    }
}
