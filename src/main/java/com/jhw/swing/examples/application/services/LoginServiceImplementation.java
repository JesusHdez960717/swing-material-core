package com.jhw.swing.examples.application.services;

import com.clean.core.app.services.LoginHandlerService;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class LoginServiceImplementation implements LoginHandlerService<String, String, Object, Boolean> {

    @Override
    public Boolean login(String user, String pass, Object... args) {
        return user.equals("123");
    }

}
