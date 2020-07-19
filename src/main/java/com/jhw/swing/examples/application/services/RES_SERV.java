package com.jhw.swing.examples.application.services;

import com.clean.core.domain.services.Resource;
import com.clean.core.domain.services.ResourceService;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RES_SERV implements ResourceService {

    public static RES_SERV init() {
        RES_SERV res = new RES_SERV();
        Resource.registerResourceService(res);
        return res;
    }

    private RES_SERV() {
    }

    @Override
    public String getString(String string) {
        return "123";
    }

    @Override
    public Object getObject(String string) {
        return 10;
    }

}
