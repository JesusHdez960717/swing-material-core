package com.jhw.swing.examples.application;

import com.jhw.swing.examples.application.modules.SampleSwingModule;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class Main {

    public static final SwingApplication app = new SwingApplication();

    public static void main(String args[]) throws Exception {
        app.run();
        app.registerModule(new SampleSwingModule());
    }

}
