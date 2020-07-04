package com.jhw.swing.examples.application.modules;

import com.clean.core.app.services.NavigationService;
import com.jhw.swing.util.JOP;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SampleModuleNavigator implements NavigationService {

    public static final String NAV_TEST = "sample.test.android";

    @Override
    public void navigateTo(String string, Object... os) {
        switch (string) {
            case NAV_TEST:
                JOP.error("Navegando para el modulo de prueba.");
                break;
        }
    }

}
