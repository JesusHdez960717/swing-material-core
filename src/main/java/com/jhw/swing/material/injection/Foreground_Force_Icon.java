/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.injection;

import com.jhw.swing.material.effects.Iconable;
import com.jhw.swing.utils.icons.DerivableIcon;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.swing.Icon;
import javax.swing.JComponent;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Foreground_Force_Icon {

    public static final String SIGNATURE = "setForeground";

    public static class Interceptor<T extends JComponent & Iconable> implements MethodInterceptor {

        public static Interceptor from() {
            return new Interceptor();
        }

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            Object answ = invocation.proceed();

            T component = (T) invocation.getThis();
            Icon icon = component.getIcon();
            if (icon != null && icon instanceof DerivableIcon) {
                icon = ((DerivableIcon) icon).deriveIcon(component.getForeground());
            }
            component.setIcon(icon);

            return answ;
        }
    }
}
