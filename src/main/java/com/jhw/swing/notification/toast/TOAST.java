package com.jhw.swing.notification.toast;

import com.jhw.swing.notification.toast.types.notification.DialogNotificationToastGeneral;
import com.jhw.swing.notification.toast.types.text.DialogTextToastGeneral;
import java.awt.Color;
import javax.swing.ImageIcon;
import com.jhw.swing.personalization.PersonalizationMaterial;
import com.jhw.swing.material.standars.MaterialIcons;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class TOAST {

    public static void makeText(String text) {
        new DialogTextToastGeneral(PersonalizationMaterial.getInstance().getSecondsActive(), text);
    }

    public static void makeText(int seconds, String text) {
        new DialogTextToastGeneral(seconds * 1000, text);
    }

    public static void makeNotification(ImageIcon icon, String text, Color color) {
        new DialogNotificationToastGeneral(
                PersonalizationMaterial.getInstance().getSecondsActive(),
                text, icon, color);
    }

    public static void makeNotification(int seconds, ImageIcon icon, String text, Color color) {
        new DialogNotificationToastGeneral(seconds * 1000, text, icon, color);
    }

    public static void makeNotificationFAIL(String text) {
        DialogNotificationToastGeneral.from(PersonalizationMaterial.getInstance().getSecondsActive(),
                text,
                MaterialIcons.BLOCK,
                PersonalizationMaterial.getInstance().getColorError());
    }

    public static void makeNotificationOK(String text) {
        new DialogNotificationToastGeneral(PersonalizationMaterial.getInstance().getSecondsActive(),
                text,
                MaterialIcons.CHECK,
                PersonalizationMaterial.getInstance().getColorDone());
    }

    public static void makeNotificationCreate(Object obj) {
        new DialogNotificationToastGeneral(PersonalizationMaterial.getInstance().getSecondsActive(),
                "Elemento " + ObjectToString(obj) + "CREADO exitosamente",
                MaterialIcons.ADD,
                PersonalizationMaterial.getInstance().getColorDone());
    }

    public static void makeNotificationDelete(Object obj) {
        new DialogNotificationToastGeneral(PersonalizationMaterial.getInstance().getSecondsActive(),
                "Elemento " + ObjectToString(obj) + "ELIMINADO exitosamente",
                MaterialIcons.DELETE_FOREVER,
                PersonalizationMaterial.getInstance().getColorError());
    }

    public static void makeNotificationEdit(Object obj) {
        new DialogNotificationToastGeneral(PersonalizationMaterial.getInstance().getSecondsActive(),
                "Elemento " + ObjectToString(obj) + "EDITADO exitosamente",
                MaterialIcons.EDIT,
                PersonalizationMaterial.getInstance().getColorInfo());
    }

    public static void makeNotificationInfo(String text) {
        new DialogNotificationToastGeneral(PersonalizationMaterial.getInstance().getSecondsActive(),
                text,
                MaterialIcons.INFO_OUTLINE,
                PersonalizationMaterial.getInstance().getColorInfo());
    }

    private static String ObjectToString(Object obj) {
        return obj.toString().trim().isEmpty() ? "" : "\'" + obj.toString().toUpperCase() + "\'\n";
    }
}
