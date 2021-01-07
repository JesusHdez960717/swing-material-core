/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.injection;

import com.root101.swing.util.Utils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.swing.JComponent;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * <p>
 * Keep on mind that setting a background color in a Material component will
 * also set the foreground color to either white or black and the ripple color
 * to white or darker shade of the color, depending of how bright or dark is the
 * chosen background color. If you want to use a custom foreground color and
 * ripple color, ensure the background color has been set first.
 * </p>
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Background_Force_Foreground {

    public static final String SIGNATURE = "setBackground";

    public static class Interceptor implements MethodInterceptor {

        public static Interceptor from() {
            return new Interceptor();
        }

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            Object answ = invocation.proceed();
            
            JComponent component = (JComponent) invocation.getThis();
            component.setForeground(Utils.getForegroundAccording(component.getBackground()));
            
            return answ;
        }
    }
}
