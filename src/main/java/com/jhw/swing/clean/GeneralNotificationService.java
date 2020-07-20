/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.clean;

import com.clean.core.app.services.NotificationService;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.notification.toast.types.notification.DialogNotificationToastGeneral;
import com.jhw.swing.personalization.PersonalizationMaterial;
import com.clean.core.app.services.GeneralNotificationType;
import com.clean.core.app.services.Notification;
import com.jhw.swing.material.standars.MaterialImages;
import com.jhw.utils.interfaces.Formateable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GeneralNotificationService implements NotificationService {

    public static final String DELETE = "DELETE";

    public static GeneralNotificationService init() {
        GeneralNotificationService notif = new GeneralNotificationService();
        Notification.registerNotificationService(notif);
        return notif;
    }

    public GeneralNotificationService() {
    }

    @Override
    public void showNotification(String type, Object obj) {
        switch (type) {
            case GeneralNotificationType.NOTIFICATION_ERROR:
                DialogNotificationToastGeneral.from(
                        PersonalizationMaterial.getInstance().getSecondsActive(),
                        objectToString(obj),
                        MaterialIcons.BLOCK,
                        PersonalizationMaterial.getInstance().getColorError());
                break;
            case GeneralNotificationType.NOTIFICATION_SUCCESS:
                DialogNotificationToastGeneral.from(
                        PersonalizationMaterial.getInstance().getSecondsActive(),
                        objectToString(obj),
                        MaterialIcons.CHECK,
                        PersonalizationMaterial.getInstance().getColorDone());
                break;
            case GeneralNotificationType.NOTIFICATION_CREATE:
                DialogNotificationToastGeneral.from(
                        PersonalizationMaterial.getInstance().getSecondsActive(),
                        "Elemento " + objectToString(obj) + "CREADO exitosamente",
                        MaterialIcons.ADD,
                        PersonalizationMaterial.getInstance().getColorDone());
                break;
            case GeneralNotificationType.NOTIFICATION_DELETE:
                DialogNotificationToastGeneral.from(
                        PersonalizationMaterial.getInstance().getSecondsActive(),
                        "Elemento " + objectToString(obj) + "ELIMINADO exitosamente",
                        MaterialIcons.DELETE_FOREVER,
                        PersonalizationMaterial.getInstance().getColorError());
                break;
            case GeneralNotificationType.NOTIFICATION_EDIT:
                DialogNotificationToastGeneral.from(
                        PersonalizationMaterial.getInstance().getSecondsActive(),
                        "Elemento " + objectToString(obj) + "EDITADO exitosamente",
                        MaterialIcons.EDIT,
                        PersonalizationMaterial.getInstance().getColorInfo());
                break;
            case GeneralNotificationType.NOTIFICATION_INFO:
                DialogNotificationToastGeneral.from(
                        PersonalizationMaterial.getInstance().getSecondsActive(),
                        objectToString(obj),
                        MaterialIcons.INFO_OUTLINE,
                        PersonalizationMaterial.getInstance().getColorInfo());
                break;
            case GeneralNotificationType.NOTIFICATION_WARNING:
                DialogNotificationToastGeneral.from(
                        PersonalizationMaterial.getInstance().getSecondsActive(),
                        objectToString(obj),
                        MaterialIcons.WARNING,
                        PersonalizationMaterial.getInstance().getColorWarning());
                break;
        }
    }

    @Override
    public boolean showConfirmDialog(String type, Object obj) {
        switch (type) {
            case GeneralNotificationType.CONFIRM_CREATE:
                return JOptionPane.showConfirmDialog(null,
                        "Seguro desea crear el elemento " + objectToString(obj, false) + " ?",
                        "Crear",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(MaterialImages.CREATE)) == 0;

            case GeneralNotificationType.CONFIRM_EDIT:
                return JOptionPane.showConfirmDialog(null,
                        "Seguro desea editar el elemento " + objectToString(obj, false) + " ?",
                        "Editar",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(MaterialImages.EDIT)) == 0;

            case GeneralNotificationType.CONFIRM_DELETE:
                return showConfirmDialogDelete(obj);

            case GeneralNotificationType.CONFIRM_CANCEL:
                return JOptionPane.showConfirmDialog(null, "Seguro desea cancelar ?",
                        "Cancel",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.ERROR_MESSAGE) == 0;

            case GeneralNotificationType.CONFIRM_CONTINUE:
                return JOptionPane.showConfirmDialog(null, "Seguro desea continuar ?",
                        "Terminar",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == 0;
        }
        return false;
    }

    @Override
    public Object showInputDialog(String type, Object toDisplay) {
        return JOptionPane.showInputDialog(objectToString(toDisplay));
    }

    @Override
    public boolean contain(String string) {
        Field[] fields = GeneralNotificationType.class.getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())
                    && String.class.isAssignableFrom(field.getType())) {
                try {
                    if (((String) field.get(null)).equals(string)) {
                        return true;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(GeneralNotificationService.class.getName()).log(Level.WARNING, null, ex);
                }
            }
        }
        return false;
    }

    private boolean showConfirmDialogDelete(Object obj) {
        String text = "Seguro desea eliminar " + objectToString(obj, false) + " ?";
        if (JOptionPane.showConfirmDialog(null, text, "Eliminar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, MaterialIcons.DELETE_FOREVER.deriveIcon(36f)) == 0) {
            if (PersonalizationMaterial.getInstance().isDouble_delete_check()) {
                String conf = JOptionPane.showInputDialog(null, "Para confirmar introduzca la palabra: " + DELETE);
                if (conf != null && conf.toUpperCase().matches(DELETE)) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    private String objectToString(Object obj) {
        return objectToString(obj, true);
    }

    private String objectToString(Object obj, boolean ln) {
        String toString;
        if (obj == null) {
            toString = "";
        } else if (obj instanceof Formateable) {
            toString = ((Formateable) obj).format();
        } else {
            toString = obj.toString().trim();
        }
        String finall = toString.isEmpty() ? "" : "\'" + toString.toUpperCase() + "\'";
        if (ln) {
            finall += "\n";
        }
        return finall;
    }
}
