/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.util;

import com.jhw.swing.material.standards.MaterialColors;
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
        /*NotificationFactory.buildTextTOAST(NotificationBuilder.builder()
                .location(NotificationLocation.DOWN_CENTER)
                .color(MaterialColors.GREY_900)
                .text("\"" + textToCopy + "\" copiado al portapapeles"));*/
    }
}
