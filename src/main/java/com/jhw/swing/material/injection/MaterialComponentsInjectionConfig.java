package com.jhw.swing.material.injection;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.jhw.swing.material.effects.Iconable;
import javax.swing.JButton;
import javax.swing.JComponent;

public class MaterialComponentsInjectionConfig extends AbstractModule {

    public static final MaterialComponentsInjectionConfig INSTANCE = new MaterialComponentsInjectionConfig();

    protected MaterialComponentsInjectionConfig() {
    }

    @Override
    protected void configure() {
        bindInterceptor(
                Matchers.subclassesOf(JComponent.class).and(Matchers.annotatedWith(Background_Force_Foreground.class)),
                MatcherByName.from(Background_Force_Foreground.SIGNATURE),
                Background_Force_Foreground.Interceptor.from()
        );

        bindInterceptor(
                Matchers.subclassesOf(JComponent.class).and(Matchers.subclassesOf(Iconable.class)).and(Matchers.annotatedWith(Foreground_Force_Icon.class)),
                MatcherByName.from(Foreground_Force_Icon.SIGNATURE),
                Foreground_Force_Icon.Interceptor.from()
        );

        //bind(ButtonAopInter.class).to(ButtonAOP.class);
    }

}
