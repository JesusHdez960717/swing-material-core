/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.clean;

import com.clean.core.app.services.NotificationServiceFunctional;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.notification.toast.types.notification.DialogNotificationToastGeneral;
import com.jhw.swing.personalization.PersonalizationMaterial;
import com.clean.core.app.services.GeneralNotificationType;
import com.clean.core.app.services.Notification;
import com.jhw.swing.material.standars.MaterialImages;
import com.jhw.utils.interfaces.Formateable;
import java.util.function.Function;
import java.util.function.Predicate;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GeneralNotificationService extends NotificationServiceFunctional {

    public static final String DELETE = "DELETE";

    public static GeneralNotificationService init() {
        GeneralNotificationService notif = new GeneralNotificationService();
        Notification.registerNotificationService(notif);
        return notif;
    }

    public GeneralNotificationService() {
        addAll();
    }

    @Override
    protected void addNotifications() {
        super.addNotification(GeneralNotificationType.NOTIFICATION_ERROR, (Object t) -> {
            DialogNotificationToastGeneral.from(
                    PersonalizationMaterial.getInstance().getSecondsActive(),
                    objectToString(t),
                    MaterialIcons.BLOCK,
                    PersonalizationMaterial.getInstance().getColorError());
        });
        super.addNotification(GeneralNotificationType.NOTIFICATION_SUCCESS, (Object t) -> {
            DialogNotificationToastGeneral.from(
                    PersonalizationMaterial.getInstance().getSecondsActive(),
                    objectToString(t),
                    MaterialIcons.CHECK,
                    PersonalizationMaterial.getInstance().getColorDone());
        });
        super.addNotification(GeneralNotificationType.NOTIFICATION_CREATE, (Object t) -> {
            DialogNotificationToastGeneral.from(
                    PersonalizationMaterial.getInstance().getSecondsActive(),
                    "Elemento " + objectToString(t) + "CREADO exitosamente",
                    MaterialIcons.ADD,
                    PersonalizationMaterial.getInstance().getColorDone());
        });
        super.addNotification(GeneralNotificationType.NOTIFICATION_DELETE, (Object t) -> {
            DialogNotificationToastGeneral.from(
                    PersonalizationMaterial.getInstance().getSecondsActive(),
                    "Elemento " + objectToString(t) + "ELIMINADO exitosamente",
                    MaterialIcons.DELETE_FOREVER,
                    PersonalizationMaterial.getInstance().getColorError());
        });
        super.addNotification(GeneralNotificationType.NOTIFICATION_EDIT, (Object t) -> {
            DialogNotificationToastGeneral.from(
                    PersonalizationMaterial.getInstance().getSecondsActive(),
                    "Elemento " + objectToString(t) + "EDITADO exitosamente",
                    MaterialIcons.EDIT,
                    PersonalizationMaterial.getInstance().getColorInfo());
        });
        super.addNotification(GeneralNotificationType.NOTIFICATION_INFO, (Object t) -> {
            DialogNotificationToastGeneral.from(
                    PersonalizationMaterial.getInstance().getSecondsActive(),
                    objectToString(t),
                    MaterialIcons.INFO_OUTLINE,
                    PersonalizationMaterial.getInstance().getColorInfo());
        });
        super.addNotification(GeneralNotificationType.NOTIFICATION_WARNING, (Object t) -> {
            DialogNotificationToastGeneral.from(
                    PersonalizationMaterial.getInstance().getSecondsActive(),
                    objectToString(t),
                    MaterialIcons.WARNING,
                    PersonalizationMaterial.getInstance().getColorWarning());
        });
    }

    @Override
    protected void addConfirmDialog() {
        super.addConfirmDialog(GeneralNotificationType.CONFIRM_CREATE, (Object t)
                -> JOptionPane.showConfirmDialog(null,
                        "Seguro desea crear el elemento " + objectToString(t, false) + " ?",
                        "Crear",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(MaterialImages.CREATE)) == 0);
        super.addConfirmDialog(GeneralNotificationType.CONFIRM_EDIT, (Object t)
                -> JOptionPane.showConfirmDialog(null,
                        "Seguro desea editar el elemento " + objectToString(t, false) + " ?",
                        "Editar",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(MaterialImages.EDIT)) == 0);
        super.addConfirmDialog(GeneralNotificationType.CONFIRM_DELETE, (Object t)
                -> showConfirmDialogDelete(t));

        super.addConfirmDialog(GeneralNotificationType.CONFIRM_CANCEL, (Object t)
                -> JOptionPane.showConfirmDialog(null, "Seguro desea cancelar ?",
                        "Cancel",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.ERROR_MESSAGE) == 0);
        super.addConfirmDialog(GeneralNotificationType.CONFIRM_CONTINUE, (Object t)
                -> JOptionPane.showConfirmDialog(null, "Seguro desea continuar ?",
                        "Terminar",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == 0);
    }

    @Override
    protected void addInputDialog() {
        super.addInputDialog(GeneralNotificationType.DIALOG_INPUT, (Object t) -> {
            return JOptionPane.showInputDialog(objectToString(t));
        });
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
