package com.jhw.swing.examples.application.services;

import com.clean.core.app.services.NavigationService;
import com.jhw.swing.examples.application.Main;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class NavigationServiceImplementation implements NavigationService {

    @Override
    public void navigateTo(String string, Object... o) {
        Main.app.navigateTo(string, o);
    }

}
