package com.jhw.swing.examples.application.services;

import com.clean.core.app.services.ExceptionHandler;
import com.clean.core.app.services.ExceptionHandlerService;
import com.jhw.swing.util.JOP;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class EXCEPTION_SERVICE implements ExceptionHandlerService {

    public static EXCEPTION_SERVICE init() {
        EXCEPTION_SERVICE exc = new EXCEPTION_SERVICE();
        ExceptionHandler.registerExceptionHandlerService(exc);
        return exc;
    }

    private EXCEPTION_SERVICE() {
    }

    @Override
    public void handleException(Exception excptn) {
        JOP.error("EXCEPTION RRRRRUUUUUUNNNNN");
    }

}
