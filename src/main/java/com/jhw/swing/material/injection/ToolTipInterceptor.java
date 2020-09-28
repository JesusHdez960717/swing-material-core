/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.injection;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ToolTipInterceptor implements MethodInterceptor {

    public static final String SIGNATURE = "setToolTipText";

    public static ToolTipInterceptor from() {
        return new ToolTipInterceptor();
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (invocation.getArguments().length > 0 && invocation.getArguments()[0] != null) {
            String tip = invocation.getArguments()[0].toString();
            if (tip.trim().isEmpty()) {
                return null;
            }
            
            //formateo para multi-linea
            String str = invocation.getArguments()[0].toString();
            String format = "<html>" + str.replace("\n", "<br>") + "</html>";
            invocation.getArguments()[0] = format;

            return invocation.proceed();
        }
        return null;
    }
}
