package com.jhw.swing.examples.application;

import com.clean.core.app.services.NavigationService;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class NavServiceImp implements NavigationService {

    @Override
    public void navigateTo(String string, Object o) {
        Main.app.navigateTo(string, o);
    }

}
