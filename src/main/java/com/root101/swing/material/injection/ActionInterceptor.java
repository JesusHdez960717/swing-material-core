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

import com.root101.swing.util.AbstractActionUtils;
import java.awt.Color;
import javax.swing.JButton;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
