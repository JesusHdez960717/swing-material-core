/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.injection;

import com.google.inject.matcher.AbstractMatcher;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MatcherByName extends AbstractMatcher {

    private final String name;

    public static MatcherByName from(String name) {
        return new MatcherByName(name);
    }

    protected MatcherByName(String name) {
        this.name = name;
    }

    @Override
    public boolean matches(Object t) {
        return t instanceof java.lang.reflect.Method && ((java.lang.reflect.Method) t).getName().equals(name);
    }

}
