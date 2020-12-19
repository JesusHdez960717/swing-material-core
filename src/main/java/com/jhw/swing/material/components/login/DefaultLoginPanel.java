package com.jhw.swing.material.components.login;

import com.clean.core.app.services.AuthenticationHandler;
import com.clean.core.app.services.Navigation;
import com.clean.core.app.services.Notification;
import com.clean.core.app.services.NotificationsGeneralType;
import static com.clean.swing.app.RootView.DASH_NAME;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DefaultLoginPanel extends _LoginPanel {

    public DefaultLoginPanel() {
        this.addLoginAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean resp = (boolean) AuthenticationHandler.getAuthHandlerService().login(getUser(), getPass());

                setUpAnswer(resp);

                if (resp) {
                    Navigation.getNavigationService().navigateTo(DASH_NAME);
                    Notification.showNotification(NotificationsGeneralType.NOTIFICATION_LOGIN, getUser());
                }
            }
        });
    }

}
