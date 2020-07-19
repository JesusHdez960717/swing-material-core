package com.jhw.swing.examples.application.services;

import com.clean.core.app.services.LoginHandler;
import com.clean.core.app.services.LoginHandlerService;
import com.jhw.swing.examples.application.MAIN_APP_TEST;
import com.jhw.swing.examples.application.USER_ENTITY;
import java.lang.reflect.Method;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class LOGIN_SERVICE implements LoginHandlerService<String, String, Object, Boolean, USER_ENTITY> {

    public static LOGIN_SERVICE init() {
        LOGIN_SERVICE login = new LOGIN_SERVICE();
        LoginHandler.registerLoginHandlerService(login);
        return login;
    }

    private LOGIN_SERVICE() {
    }

    @Override
    public Boolean login(String user, String pass, Object... args) {
        return user.equals("123");
    }

    @Override
    public USER_ENTITY user() {
        return MAIN_APP_TEST.usuario;
    }

    @Override
    public boolean checkAccess(Method method) {
        return true;
    }
}
