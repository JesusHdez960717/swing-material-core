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

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.root101.swing.material.effects.Iconable;
import com.root101.utils.interfaces.Update;
import javax.swing.JButton;
import javax.swing.JComponent;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class MaterialComponentsInjectionConfig extends AbstractModule {

    public static final MaterialComponentsInjectionConfig INSTANCE = new MaterialComponentsInjectionConfig();

    protected MaterialComponentsInjectionConfig() {
    }

    @Override
    protected void configure() {
        //for => Background_Force_Foreground
        bindInterceptor(
                Matchers.subclassesOf(JComponent.class).and(Matchers.annotatedWith(Background_Force_Foreground.class)),
                NameMatcher.from(Background_Force_Foreground.SIGNATURE),
                Background_Force_Foreground.Interceptor.from()
        );

        //for => Foreground_Force_Icon
        bindInterceptor(
                Matchers.subclassesOf(JComponent.class).and(Matchers.subclassesOf(Iconable.class)).and(Matchers.annotatedWith(Foreground_Force_Icon.class)),
                NameMatcher.from(Foreground_Force_Icon.SIGNATURE),
                Foreground_Force_Icon.Interceptor.from()
        );

        //for => Tooltip
        bindInterceptor(
                Matchers.subclassesOf(JComponent.class),
                NameMatcher.from(ToolTipInterceptor.SIGNATURE),
                ToolTipInterceptor.from()
        );

        //for => Action, background y foreground como keys del action
        bindInterceptor(
                Matchers.subclassesOf(JButton.class),
                NameMatcher.from(ActionInterceptor.SIGNATURE),
                ActionInterceptor.from()
        );

        //for => Update
        bindInterceptor(
                Matchers.subclassesOf(Update.class),
                Matchers.annotatedWith(UpdateAfter.class),
                UpdateInterceptor.from()
        );
        //bind(ButtonAopInter.class).to(ButtonAOP.class);
    }

}
