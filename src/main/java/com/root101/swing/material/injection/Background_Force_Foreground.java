/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
