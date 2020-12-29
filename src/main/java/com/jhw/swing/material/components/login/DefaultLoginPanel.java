package com.jhw.swing.material.components.login;

import com.clean.core.app.services.AuthenticationHandler;
import com.clean.core.app.services.Navigation;
import com.clean.core.app.services.Notification;
import com.clean.core.app.services.NotificationsGeneralType;
import static com.clean.swing.app.RootView.DASH_NAME;
import java.awt.event.ActionEvent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DefaultLoginPanel extends _LoginPanel {

    public DefaultLoginPanel() {
        this.addLoginAction((ActionEvent e) -> {
            boolean resp = AuthenticationHandler.getAuthHandlerService().login(getUser(), getPass());

            setUpAnswer(resp);

            if (resp) {
                Navigation.getNavigationService().navigateTo(DASH_NAME);
                clear();
            }
        });
    }
}
