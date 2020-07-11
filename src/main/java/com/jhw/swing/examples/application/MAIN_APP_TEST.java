package com.jhw.swing.examples.application;

import com.jhw.swing.examples.application.modules.SAMPLE_SWING_MODULE;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MAIN_APP_TEST {

    public static final SWING_APP_TEST app = new SWING_APP_TEST();

    public static void main(String args[]) throws Exception {
        app.run();
        app.registerModule(new SAMPLE_SWING_MODULE());
    }

}
