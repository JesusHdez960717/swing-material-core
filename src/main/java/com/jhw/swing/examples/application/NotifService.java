package com.jhw.swing.examples.application;

import com.clean.core.app.services.NotificationService;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class NotifService implements NotificationService {

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
