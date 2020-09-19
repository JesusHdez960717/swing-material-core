/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.injection;

import com.jhw.swing.util.AbstractActionUtils;
import java.awt.Color;
import javax.swing.JButton;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ActionInterceptor implements MethodInterceptor {

    public static final String SIGNATURE = "setAction";

    public static ActionInterceptor from() {
        return new ActionInterceptor();
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object answ = invocation.proceed();

        JButton btn = (JButton) invocation.getThis();

        Color back = (Color) btn.getAction().getValue(AbstractActionUtils.KEY_BACKGROUND);
        if (back != null) {
            btn.setBackground(back);
        }

        Color fore = (Color) btn.getAction().getValue(AbstractActionUtils.KEY_FOREGROUND);
        if (fore != null) {
            btn.setForeground(fore);
        }

        return answ;
    }
}
