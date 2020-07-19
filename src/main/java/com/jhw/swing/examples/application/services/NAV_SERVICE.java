package com.jhw.swing.examples.application.services;

import com.clean.core.app.services.Navigation;
import com.clean.core.app.services.NavigationService;
import com.jhw.swing.examples.application.MAIN_APP_TEST;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class NAV_SERVICE implements NavigationService {

    public static NAV_SERVICE init() {
        NAV_SERVICE nav = new NAV_SERVICE();
        Navigation.registerNavigationService(nav);
        return nav;
    }

    private NAV_SERVICE() {
    }

    @Override
    public void navigateTo(String string, Object... o) {
        MAIN_APP_TEST.app.navigateTo(string, o);
    }

}
