/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.injection;

import com.clean.core.app.modules.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialSwingInjector {

    private final static Injector injector = Guice.createInjector(MaterialComponentsInjectionConfig.INSTANCE);

    private MaterialSwingInjector() {
    }

    public static <T> T getImplementation(Class<T> type) {
        return injector.getInstance(type);
    }

}
