package com.root101.swing.material.components.login;

import com.root101.clean.core.app.services.AuthenticationHandler;
import com.root101.clean.core.app.services.NavigationHandler;
import static com.root101.clean.swing.app.RootView.DASH_NAME;
import java.awt.event.ActionEvent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DefaultLoginPanel extends _LoginPanel {

    public DefaultLoginPanel() {
        this.addLoginAction((ActionEvent e) -> {
            boolean resp = AuthenticationHandler.getAuthenticationService().login(getUser(), getPass());

            setUpAnswer(resp);

            if (resp) {
                NavigationHandler.getNavigationService().navigateTo(DASH_NAME);
                clear();
            }
        });
    }
}
