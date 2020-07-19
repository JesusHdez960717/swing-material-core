package com.jhw.swing.examples.application.services;

import com.clean.core.domain.services.Resource;
import com.clean.core.domain.services.ResourceBundleUtils;
import com.clean.core.domain.services.ResourceService;
import com.clean.core.domain.services.DefaultResourceBundleService;
import java.net.MalformedURLException;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RES_SERV implements ResourceService {

    private final DefaultResourceBundleService resourceService;

    public static RES_SERV init() throws MalformedURLException {
        RES_SERV res = new RES_SERV();
        Resource.registerResourceService(res);
        return res;
    }

    private RES_SERV() throws MalformedURLException {
        resourceService = new DefaultResourceBundleService(
                ResourceBundleUtils.fromExternalFile("msg",
                        ResourceBundleUtils.SPANISH));
    }

    @Override
    public String getString(String string) {
        return resourceService.getString(string);
    }

    @Override
    public Object getObject(String string) {
        return 10;
    }

}
