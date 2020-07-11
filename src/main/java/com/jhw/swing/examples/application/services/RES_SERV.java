package com.jhw.swing.examples.application.services;

import com.clean.core.domain.services.ResourceService;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RES_SERV implements ResourceService{

    @Override
    public String getString(String string) {
        return "123";
    }

    @Override
    public Object getObject(String string) {
        return 10;
    }

}
