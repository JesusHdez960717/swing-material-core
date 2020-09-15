/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.property_reflection;

import com.jhw.swing.material.effects.Iconable;
import com.jhw.swing.utils.icons.DerivableIcon;
import javax.swing.Icon;
import javax.swing.JComponent;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class NameInterceptor<T extends JComponent> implements MethodInterceptor {

    public static final String SIGNATURE = "setName";

    public static NameInterceptor from() {
        return new NameInterceptor();
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object answ = invocation.proceed();
        PropertyHandler.handleProperties(invocation.getThis());
        return answ;
    }

}
