package com.jhw.swing.examples.application.services;

import com.clean.core.app.services.Notification;
import com.clean.core.app.services.NotificationService;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class NOTIF_SERV implements NotificationService {

    public static NOTIF_SERV init() {
        NOTIF_SERV notif = new NOTIF_SERV();
        Notification.registerNotificationService(notif);
        return notif;
    }

    private NOTIF_SERV() {
    }

    @Override
    public void showNotification(String string, String string1) {
    }

    @Override
    public boolean showConfirmDialog(String string, String string1) {
        return true;
    }

    @Override
    public Object showInputDialog(String string, String string1) {
        return 5;
    }

}
