package com.jhw.swing.examples.application.services;

import com.clean.core.app.services.NavigationService;
import com.jhw.swing.examples.application.MAIN_APP_TEST;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class NAV_SERVICE implements NavigationService {

    @Override
    public void navigateTo(String string, Object... o) {
        MAIN_APP_TEST.app.navigateTo(string, o);
    }

}
