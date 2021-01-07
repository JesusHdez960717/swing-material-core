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

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
