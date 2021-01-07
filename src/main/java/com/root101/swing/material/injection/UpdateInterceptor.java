/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.injection;

import com.root101.utils.interfaces.Update;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class UpdateInterceptor implements MethodInterceptor {

    public static UpdateInterceptor from() {
        return new UpdateInterceptor();
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object answ = invocation.proceed();

        ((Update) invocation.getThis()).update();

        return answ;
    }
}
