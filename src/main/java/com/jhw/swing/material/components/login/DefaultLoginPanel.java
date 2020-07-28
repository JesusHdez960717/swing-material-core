package com.jhw.swing.material.components.login;

import com.clean.core.app.services.LoginHandler;
import com.clean.core.app.services.Navigation;
import static com.clean.swing.app.RootView.DASH_NAME;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.notification.toast.types.notification.DialogNotificationToastGeneral;
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
                boolean resp = (boolean) LoginHandler.getLoginHandlerService().login(getUser(), getPass());

                setUpAnswer(resp);

                if (resp) {
                    Navigation.getNavigationService().navigateTo(DASH_NAME);
                    TOAST_welcome(getUser());
                }
            }
        });
    }

    public static void TOAST_welcome(String user) {
        new DialogNotificationToastGeneral(5,
                "Bienvenido de nuevo\n" + user,
                MaterialIcons.PERSON,
                MaterialColors.BLUE_400);
    }
}
