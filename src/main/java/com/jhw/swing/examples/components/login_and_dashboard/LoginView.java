package com.jhw.swing.examples.components.login_and_dashboard;

import com.jhw.utils.security.SHA;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class LoginView extends com.jhw.swing.material.components.login._LoginPanel {

    public LoginView() {
        super();
    }

    public boolean login() {
        String user = getUser();
        String pass = getPass();
        if (user == null || user.isEmpty() || pass.isEmpty()) {
            return false;
        } else {
            return user.matches("123") && pass.matches(SHA.hash256("123"));
        }
    }
}
