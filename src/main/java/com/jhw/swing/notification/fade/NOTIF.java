package com.jhw.swing.notification.fade;

import com.jhw.swing.personalization.PersonalizationMaterial;
import com.jhw.swing.material.standars.MaterialIcons;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class NOTIF {

    public static void makeNotificationFAIL(String text) {
        new NotificationDialogGeneral(PersonalizationMaterial.getInstance().getSecondsActive(),
                text,
                MaterialIcons.BLOCK,
                PersonalizationMaterial.getInstance().getColorError());
    }

    public static void makeNotificationOK(String text) {
        new NotificationDialogGeneral(PersonalizationMaterial.getInstance().getSecondsActive(),
                text,
                MaterialIcons.CHECK,
                PersonalizationMaterial.getInstance().getColorDone());
    }

    public static void makeNotificationCreate(Object obj) {
        new NotificationDialogGeneral(PersonalizationMaterial.getInstance().getSecondsActive(),
                "Elemento " + ObjectToString(obj) + "CREADO exitosamente",
                MaterialIcons.ADD,
                PersonalizationMaterial.getInstance().getColorDone());
    }

    public static void makeNotificationDelete(Object obj) {
        new NotificationDialogGeneral(PersonalizationMaterial.getInstance().getSecondsActive(),
                "Elemento " + ObjectToString(obj) + "ELIMINADO exitosamente",
                MaterialIcons.DELETE_FOREVER,
                PersonalizationMaterial.getInstance().getColorError());
    }

    public static void makeNotificationEdit(Object obj) {
        new NotificationDialogGeneral(PersonalizationMaterial.getInstance().getSecondsActive(),
                "Elemento " + ObjectToString(obj) + "EDITADO exitosamente",
                MaterialIcons.EDIT,
                PersonalizationMaterial.getInstance().getColorInfo());
    }

    public static void makeNotificationInfo(String text) {
        new NotificationDialogGeneral(PersonalizationMaterial.getInstance().getSecondsActive(),
                text,
                MaterialIcons.INFO_OUTLINE,
                PersonalizationMaterial.getInstance().getColorInfo());
    }

    private static String ObjectToString(Object obj) {
        return obj.toString().trim().isEmpty() ? "" : "\'" + obj.toString().toUpperCase() + "\'\n";
    }
}
