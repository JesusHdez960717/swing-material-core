package com.jhw.swing.material.injection;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.jhw.swing.material.effects.Iconable;
import com.jhw.utils.interfaces.Update;
import javax.swing.JButton;
import javax.swing.JComponent;

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
